package tqs.airquality.controller;


import tqs.airquality.model.AQResponse;
import tqs.airquality.model.Data;
import tqs.airquality.service.AQServiceImpl;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
public class AQController {
    private Map<Integer,String> stats;
    public AQController(){
        stats = new HashMap<Integer,String>();
        stats.put(0, "None");
        stats.put(1, "Low");
        stats.put(2, "Medium");
        stats.put(3, "High");
        stats.put(4, "Very High");
    }

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AQServiceImpl<AQResponse> AQService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/airquality/Porto";
    }

    @RequestMapping(value = "/airquality", method = RequestMethod.GET)
    public String airquality() {
        return "redirect:/airquality/Porto";
    }

    @RequestMapping(value = "/airquality/{city_name}", method = RequestMethod.GET)
    public String getAirQuality(Model model, @PathVariable("city_name") String city_name) throws Exception {

        AQResponse aqresponse = AQService.getAirQuality(city_name);
        List<Data> data = aqresponse.getData();

        model.addAttribute("city_name", city_name);
        model.addAttribute("mold_level", stats.get(data.get(0).getMold_level()));
        model.addAttribute("aqi", data.get(0).getAqi());
        model.addAttribute("pm10", String.valueOf(data.get(0).getPm10()) + " µg/m³");
        model.addAttribute("co", String.valueOf(data.get(0).getCo()) + " µg/m³");
        model.addAttribute("o3", String.valueOf(data.get(0).getO3()) + " µg/m³");
        model.addAttribute("predominant_pollen_type", data.get(0).getPredominant_pollen_type());
        model.addAttribute("so2", String.valueOf(data.get(0).getSo2()) + " µg/m³");
        model.addAttribute("pollen_level_tree", stats.get(data.get(0).getPollen_level_tree()));
        model.addAttribute("pollen_level_weed", stats.get(data.get(0).getPollen_level_weed()));
        model.addAttribute("no2", String.valueOf(data.get(0).getNo2()) + " µg/m³");
        model.addAttribute("pm25", String.valueOf(data.get(0).getPm25()) + " µg/m³");
        model.addAttribute("pollen_level_grass", stats.get(data.get(0).getPollen_level_grass()));

        return "airquality";
    }

    @PostMapping("/choosecity")
    public String showPage(@ModelAttribute("city") String city) {
        System.out.println(city);
        return "redirect:/airquality/"+city;

    }
}

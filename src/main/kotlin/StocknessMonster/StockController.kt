package StocknessMonster

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController(private val restTemplate: RestTemplate = RestTemplate()) {

    @GetMapping("/")
    fun getStockJson(): RestResult<String> {
        return restTemplate.get("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=demo")
    }
}

package StocknessMonster

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController {

    var apiKey = System.getenv("api.key")

    @GetMapping("{tickerSymbol}")
    fun getStockJson(@PathVariable tickerSymbol: String): RestResult<String> =
        RestTemplate()
            .get("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=$tickerSymbol&apikey=$apiKey")
}

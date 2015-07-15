import alexadewit_on_github.icelandic_economy.db._

import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._
import scalaz._

import MarketTypeCrestDecoders._

class MarketTypeSpec extends FlatSpec {

  //[SIC] ;)
  "Crest MarketTypes" should "be decodable from their retarded format" in {
    val inputStr = """
    {
      "marketGroup": {
        "href": "https://public-crest.eveonline.com/market/groups/1482/"
        , "id": 1482
        , "id_str": "1482"
      }
      , "type": {
        "id_str": "3087"
        , "href": "https://public-crest.eveonline.com/types/3087/"
        , "id": 3087
        , "name": "Zainou 'Gnome' Shield Emission Systems SE-806"
        , "icon": {
          "href": "https://image.eveonline.com/Type/3087_64.png"
        }
      }
    }
    """
    val expected = MarketType( 3087,  1482,
      "Zainou 'Gnome' Shield Emission Systems SE-806",
      "https://image.eveonline.com/Type/3087_64.png"
    )
    assert( Parse.decodeEither[MarketType]( inputStr ) == \/-( expected ) )
  }
}



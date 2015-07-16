import alexadewit_on_github.icelandic_economy.db._
import alexadewit_on_github.icelandic_economy.crest._

import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._
import scalaz._

import MarketGroupCrestDecoders._

class MarketGroupSpec extends FlatSpec {

  "Crest MarketGroups" should "be decodable without losing critical information" in {
    val inputStr = """
    {
      "parentGroup": {
        "href": "https://public-crest.eveonline.com/market/groups/350001/"
      }
      , "href": "https://public-crest.eveonline.com/market/groups/369234/"
      , "name": "Boosters & Services"
      , "types": {
        "href": "https://public-crest.eveonline.com/market/types/?group=https://public-crest.eveonline.com/market/groups/369234/"
      }
      , "description": "Boosters and Services"
    }
    """
    val expected = MarketGroup( 369234, 350001, "Boosters & Services", "Boosters and Services" )
    
    assert( Parse.decodeEither[MarketGroup]( inputStr ) == \/-( expected ) )
  }
}

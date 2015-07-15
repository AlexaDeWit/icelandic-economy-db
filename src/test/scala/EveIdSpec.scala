import alexadewit_on_github.icelandic_economy.db._

import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._
import scalaz._

import EveIdCrestDecoders._

class EveIdSpec extends FlatSpec {
  
  "MarketGroups" should "be decodable into an EveId" in {
    val expected = \/-(EveId(369234 ))
    val inputStr = """
      "https://public-crest.eveonline.com/market/groups/369234/"
    """
    assert( Parse.decodeEither[EveId]( inputStr ) == expected )
  }
}

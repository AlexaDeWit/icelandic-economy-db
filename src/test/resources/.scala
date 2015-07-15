import alexadewit_on_github.icelandic_economy.db._

import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._

import EveIdCrestDecoders._

class EveIdSpec extends FlatSpec {

  "MarketGroupHrefs" should "parse into EveIds" in {
    val href = "https://public-crest.eveonline.com/market/groups/350001/"
    val expected = EveId(350001)
    assert( Parse.decodeEither[EveId](href) == expected )
  }
}

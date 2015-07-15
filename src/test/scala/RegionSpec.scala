import alexadewit_on_github.icelandic_economy.db._

import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._
import scalaz._

import RegionCrestDecoders._


class RegionSpec extends FlatSpec {

  "Crest Regions" should "be decodable including their id from the eve endpoint" in {
    val inputStr = """
    {
      "href": "https://public-crest.eveonline.com/regions/10000006/"
      , "name": "Wicked Creek"
    }
    """
    val expected = Region( 10000006, "Wicked Creek" )
    assert( Parse.decodeEither[Region]( inputStr ) == \/-( expected ) )
  }
}


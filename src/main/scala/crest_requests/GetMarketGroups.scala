package alexadewit_on_github.icelandic_economy.crest

import org.http4s.Http4s._
import scalaz.concurrent.Task

object GetMarketGroups {

  val client = org.http4s.client.blaze.defaultClient
  def apply() : String = {
    val json: Task[String] = client(
      uri( "https://public-crest.eveonline.com/market/groups/")
    ).as[String]

    //I think a Task's run method is just the resulting content..
    json.run
  }
}


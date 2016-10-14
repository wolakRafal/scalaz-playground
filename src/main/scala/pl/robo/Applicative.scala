
package pl.robo
import scalaz._
import Scalaz._

object Applicative extends App {

  val l = 1.point[Some]

  9.some <*> {(_:Int) + 3}.some

  val x = (1.some |@| 5.some) { _ + _}
  val y = (1.some |@| none[Int]) { _ + _}


  val yv = (1.some |@| none[Int] |@| 3.some) { _ + _ + _}


  List(0,1,3).map(some)

}

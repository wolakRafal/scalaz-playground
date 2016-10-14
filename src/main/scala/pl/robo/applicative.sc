
import scalaz._
import Scalaz._


// Lists are applicative functors
List(1,2,3) <*> List((_:Int) * 0, (_:Int) + 100, (x: Int) => x * x)
// res0: List[Int] = List(0, 0, 0, 101, 102, 103, 1, 4, 9)

(List("ha", "heh", "hmm") |@| List("?", "!", ".")) { _ + _}
//res1: List[String] = List(ha?, ha!, ha., heh?, heh!, heh., hmm?, hmm!, hmm.)

Apply[Option].lift2((_:Int) :: (_: List[Int]))

Apply[List].lift2((_:Int) :: (_: List[Int]))

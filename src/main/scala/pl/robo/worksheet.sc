val add: (Int, Int) => Int = _ + _

val addCurried = add.curried

val add10 = add(10, _: Int)

val add11 = addCurried(11)

List(1,2,3,4).map(add10)
List(1,2,3,4).map(add11)

// Applicative
val r = List(1, 2, 3, 4) map {(_: Int) * (_:Int)}.curried

r map{_ (9)}

//
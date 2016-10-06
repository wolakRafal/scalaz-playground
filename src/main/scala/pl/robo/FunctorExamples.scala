package pl.robo


/**
  * Created by robo on 06/10/16.
  */
object FunctorExamples extends App {

  trait Functor[F[_]] {
    def map[A,B](fa: F[A])(f: A => B): F[B]
  }


  // Applicatve
  trait Applicative[F[_]] extends Apply[F] {
    // this is constructor
    def point[A](a: => A): F[A]
    /** alias for `point` */
    def pure[A](a: => A): F[A] = point(a)

  }

  trait Apply[F[_]] extends Functor[F] {
//    <*> takes a functor that has a function in it and another functor
// and extracts that function from the first functor
// and then maps it over the second one.
    def ap[A,B](fa: => F[A])(f: => F[A => B]): F[B]
  }

  trait Monoid[A] extends Semigroup[A] {
    ////
    /** The identity element for `append`. */
    def zero: A

  }

  trait Semigroup[A]  {
    def append(a1: A, a2: => A): A
  }


  trait Monad[F[_]] extends Applicative[F] with Bind[F] { self =>
    ////
  }

  trait Bind[F[_]] extends Apply[F] { self =>
    /** Equivalent to `join(map(fa)(f))`. */
    def bind[A, B](fa: F[A])(f: A => F[B]): F[B]
  }

  val add1: Int => Int = 1 + _:Int

  println(List(1,2,3).map(add1))

}

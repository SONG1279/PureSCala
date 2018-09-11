class Rational(n: Int, d: Int) {
  require(d != 0)



  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val demon: Int = d / g

  def this(n: Int) = this(n, 1)


  def +(that: Rational) = new Rational(
    numer * that.demon + that.numer * demon,
    demon * that.demon
  )
  def +(i: Int) = new Rational(
    numer + i * demon, demon
  )

  def -(that: Rational) = new Rational(
    numer * that.demon - that.numer * demon,
    demon * that.demon
  )
  def -(i: Int) = new Rational(
    numer - i * demon, demon
  )

  def *(that: Rational) = new Rational(
    numer * that.numer, demon * that.demon
  )
  def *(i: Int) = new Rational(
    numer * i, demon
  )

  def /(that: Rational) = new Rational(
    numer * that.demon, demon * that.numer
  )
  def /(i: Int) = new Rational(
    numer, demon * i
  )

  def lessThan(that: Rational) =
    this.numer * that.demon < this.demon * that.numer

  def max(that: Rational) =
    if(this.lessThan(that)) that else this




  override def toString = s"$numer/$demon"

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)


}


object test1{
  def main(args: Array[String]): Unit = {
    val x = new Rational(66, 42)
    val y = new Rational(4,7)

    println((x + y).toString)
  }
}
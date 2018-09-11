import java.io.{File, PrintWriter}

import scala.io.Source


object test {

  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally {
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    val file = new File("D:\\code\\file\\test.text")
    withPrintWriter(file){
      writer => writer.println(new java.util.Date)
    }
  }
}
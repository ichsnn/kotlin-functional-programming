package com.dicoding.kotlin

fun main() {
  val fullName1 = getFullName(first = "Kotlin", middle = "is", last = "Awesome")
  val fullName2 = getFullName(middle = "is", first = "Kotlin", last = "Awesome")
  val fullName3 = getFullName()
  val fullName4 = getFullName(first = "Dicoding")
  println(fullName1) // Kotlin is Awesome
  println(fullName2) // Kotlin is Awesome
  println(fullName3) // Kotlin is Awesome
  println(fullName4) // Dicoding is Awesome

  val number = sumNumbers(10, 20, 30, 40)
  println(number) // 100

  val numberSize = getNumberSize(10, 20, 30, 40, 50)
  println(numberSize) // 5

  val numberOfArray = intArrayOf(10, 20, 30, 40)
  // * this is spread operator for array
  sets(10, 20, 20, *numberOfArray, 40)

  // Extension Functions
  10.printInt() // output : 10
  (10.plusThree()).printInt() // output : 13

  // Extension Properties
  println(10.slice) // output : 5

  // Nullable Receiver
  val value2: Int? = null
  println(value2.slice)

  // Function Type
  val sum: Arithmetic = { i1, i2 -> i1 + i2 }
  val multiply: Arithmetic = { i1, i2 -> i1 + i2 }

  val sumResult = sum.invoke(10, 10)
  val multiplyResult = multiply.invoke(20, 20)

  println(sumResult)
  println(multiplyResult)

  sum?.invoke(10, 20)

  message()
  printMessage("Hello World!")
  println(messageLenght("Hello World!"))

  printResult(10, sumOp)

  val msg = buildString {
    append("Hello ")
    append("from ")
    append("Lambda ")
  }
  println(msg)

  // lambda receiver (this): run, with, apply
  val buildStr = StringBuilder().apply {
    append("Hello ")
    append("Kotlin ")
  }

  // lambda argument (it): it, also
  val text = "Hello"
  text.let {
    val message = "$it kotlin"
    println(message)
  }
}

fun buildString(action: StringBuilder.() -> Unit): String {
  val stringBuilder = StringBuilder()
  stringBuilder.action()
  return stringBuilder.toString()
}

var sumOp: (Int) -> Int = { value -> value + value }

inline fun printResult(value: Int, sumOp: (Int) -> Int) {
  val result = sumOp(value)
  println(result)
}

val message = { println("Hello Form Lambda") }

val printMessage = { message: String -> println(message) }

val messageLenght = { message: String -> message.length }

// val comparator = object : Runnable{
//   override fun run() {
//     TODO("Not yet implemented")
//   }
// }

// with lambda i can simplify the code above with
val comparator = Runnable {
  // TODO
}

typealias Arithmetic = (Int, Int) -> Int?

val Int?.slice: Int
  get() = if (this == null) 0 else this.div(2)

val Int.slice: Int
  get() = this / 2

fun Int.printInt() {
  println("value $this")
}

fun Int.plusThree(): Int {
  return this + 3
}

fun getFullName(first: String = "Kotlin", middle: String = "is", last: String = "Awesome"): String {
  return "$first $middle $last"
}

fun sumNumbers(vararg number: Int): Int {
  return number.sum()
}

fun getNumberSize(vararg number: Int): Int {
  return number.size
}

// we cant use 2 params with vararg
// fun sumNumbers(vararg number: Int, vararg number2: Int)

// the vararg parameter should be last position but we also can move to other position but you should use named argument if want to use
/*
fun sets(name: String, vararg number: Int): Int {
  ...
}
 */

fun sets(vararg number: Int): Unit {
  println(number)
}
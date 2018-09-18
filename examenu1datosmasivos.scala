// 1 -
println("verifique si un numero es par")
def isPar (num: Int): Boolean={
    if(num % 2 == 0){
      return true
    }
  return false
}
print("Ingrese un numero para saber si es par o impar: ")
val input = readInt
print("El valor es: ")
println(isPar(input))//False si es impar y True si es par
println("")
readLine

//
println("2..-Verificacion de numeros pares de una lista")
def pares (numeros: Int): Boolean={
    if (numeros % 2 == 0) {
      return true
    }
  return false
}
val listas = List(20,3,30,7,19)
var a = 0
for(a <- listas){
  if (a <= a) {
    print("El valor " + a + " es: ")
    println(pares(a))
  }
}
println("")
readLine
// 3 -
println("3 - 7 Afortunado")
val numfortuna = List(7,7)
def afortunado (siete: List[Int]): Int={
  var sumando = 0
  for (n <- fortuna){
    if(n == 7){
      sumando += n*2
    }else {
      sumando += n
    }
  }
  return sumando
  }
println(afortunado(numfortuna))
println("")
readLine

// 4-
println("4 - puedes equilibrar")
val listano = List(3,1,2,2)
def equilibrar (balancear: List[Int]): Boolean={
  val (a,b) = balancear.splitAt(balancear.length/2)
  if (a.sum == b.sum){ return true }
  else return false
}
println(equilibrar(listano))
println("")
readLine
//5
def palindromo(x: String): Boolean ={
  return (x==x.reverse)
}

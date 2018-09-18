//1.-iniciar sesion simple en spark
import org.apache.spark.sql.SparkSession
import spark.implicits._


//2.-se inicia la seison en spark y posterior se carga el csv.
val spark  = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3.- con el df te desplega el nombre de las columnas
df.columns

//4.-te describe como es el esquema
df.printSchema()

//5.-el show es para que te muestre las 5 columnas del csv
df.show(5)

//6.-te muestra la informacion general del dataframe
df.describe().show()

//7.-se crea un nuevo data frame con una columna nueva
val df2 = df.withColumn("HV Ratio" , df("High")/df("Volume"))
df2.show()

//8.-se muestra qye dia tuvo mas ganancia
df.select(max("High")).show()
df.orderBy($"High".desc).show(2)
//9.-
df.select("Volume").show()

//10.-se muestra cual es el maximo y minimo de la columna atraves del df y del .show
df.select(max("Volume") , min("Volume")).show()
readLine

//a Cuantos dias fue el cierre Inferior a $600
df.filter($"Close" < 600).count()
readLine
//b.-Porcentaje del tiempo fue el High Mayor a 500
df.filter($"High" > 500).count()*100.0 / df.count()
readLine
//c.-Correlacionde pearson entre High y Volume
df.select(corr("High" , "Volume")).show()
readLine
//d- Cual es el max High por ano?
val df3 = df.withColumn("Año",year(df("Date")))
df3.show()
readLine
//nuevo dataframe para obtener el año y el valor mas alto
val df4 = df3.select($"Año",$"High").groupBy("Año").max()
df4.show()
df4.select($"Año" , $"max(High)").orderBy($"Año".desc).show()
readLine
//e - cual es el promedio de cierre para cada mes del calendario
val df5 = df.withColumn("Mes",month(df("Date")))
df5.show()

val df6 = df5.select($"Mes",$"Close").groupBy("Mes").avg()
df6.show()
df6.select($"Mes" , $"avg(Close)").orderBy($"Mes".desc).show()
readLine

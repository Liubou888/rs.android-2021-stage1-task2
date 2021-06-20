package subtask3

import java.lang.Math.abs
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        //  return when(blockB.javaObjectType){
        return when(blockB){
            String::class -> concatenation(blockA)
            Int::class -> sum(blockA)
            LocalDate::class -> latestDate(blockA)
            else -> throw IllegalArgumentException("Illegal class in blockB: ${blockB.javaObjectType.name}")
        }
    }


    private fun concatenation(blockA: Array<*>): Any {
        var result = ""
        for (element in blockA){
            if (element is String){
                result += element
            }
        }
        return result
    }

    private fun sum(blockA: Array<*>): Any {
        var sum = 0
        for (element in blockA){
            if (element is Int){
                sum += element
            }
        }
        return sum
    }


    private fun latestDate(blockA: Array<*>): Any {
        var tempDate = LocalDate.MIN
        for (element in blockA){
            if (element is LocalDate && tempDate.isBefore(element)){
                tempDate = element
            }
        }
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return formatter.format(tempDate)
    }


}



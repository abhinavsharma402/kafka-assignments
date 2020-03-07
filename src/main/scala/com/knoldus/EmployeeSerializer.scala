package com.knoldus

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.knoldus.model.Employee
import org.apache.kafka.common.serialization.Serializer

class EmployeeSerializer extends Serializer[Employee] {
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {

  }

  override def serialize(topic: String, data: Employee): Array[Byte] = {
    var retVal: Array[Byte] = null
    val objectMapper = new ObjectMapper()
    try {
      retVal = objectMapper.writeValueAsString(data).getBytes();
      retVal
    }
    catch {
      case exception: Exception => exception.printStackTrace()
    }
    retVal
  }

  override def close(): Unit = super.close()
}


package com.knoldus

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.knoldus.model.Employee
import org.apache.kafka.common.serialization.Deserializer

class EmployeeDeserializer extends Deserializer[Employee] {
  override def close(): Unit = super.close()

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = super.configure(configs, isKey)

  override def deserialize(topic: String, data: Array[Byte]): Employee = {
    val mapper = new ObjectMapper()
    val emp = Employee
    var employee = mapper.readValue(data, classOf[Employee])
    employee
  }

}

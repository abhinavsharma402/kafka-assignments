package com.knoldus.controller

import com.knoldus.model.Employee
import net.liftweb.json.DefaultFormats

/**
 * This class is used to parse json string into case class
 */
class ParseJson {
  /**
   * parseJsonString used to parse json strng into Employee case class.
   *
   * @param jsonString json string.
   * @return Employee case class.
   */

  def parseJsonString(jsonString: String): Employee = {
    implicit val formats = DefaultFormats

    val parsedJsonData = net.liftweb.json.parse(jsonString)
    parsedJsonData.extract[Employee]
  }
}

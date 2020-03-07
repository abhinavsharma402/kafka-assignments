package com.knoldus.controller

import net.liftweb.json.DefaultFormats

/**
 * This class is used to get created json string.
 */
class JsonStringCreate {
  /**
   * getcreatedJsonString used to get created string.
   * @return json string.
   */
  def getCreatedJsonString: String = {
    implicit val formats = DefaultFormats
    """  [
      {
        "name": "abhinav",
        "id": "1",
        "address": "delhi"
      }
    ]
  """
  }

}

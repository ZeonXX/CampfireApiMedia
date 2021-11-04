package com.dzen.campfire.api_media.requests

import com.sup.dev.java.libs.api_simple.client.Request
import com.sup.dev.java.libs.json.Json

open class RResourcesCheckExist(
        var resourceId: Long
) : Request<RResourcesCheckExist.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        resourceId = json.m(inp, "resourceId", resourceId)?:0
    }

    override fun instanceResponse(json:Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var exist = false

        constructor(json:Json){
            json(false, json)
        }

        constructor(exist:Boolean){
            this.exist = exist
        }

        override fun json(inp: Boolean, json: Json) {
            exist = json.m(inp, "exist", exist)?:false
        }

    }


}
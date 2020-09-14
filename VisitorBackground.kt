package com.example.travelbook

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder


class VisitorBackground : AsyncTask<String, Void, String >() {

    override fun doInBackground(vararg params: String?): String? {
        var type = params[0]
        var user_name = params[1]
        var password = params[2]
        val login_url = "http://192.168.1.11/login.php"
        if(type=="login"){
            try{
                val url = URL(login_url)
                val httpUrlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
                httpUrlConnection.requestMethod = "POST"
                httpUrlConnection.doOutput = true
                httpUrlConnection.doInput = true
                val outputStream :OutputStream = httpUrlConnection.outputStream
                val bufferedWriter =
                    BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data: String =
                    (URLEncoder.encode("user_name", "UTF-8").toString() + "=" + URLEncoder.encode(
                        user_name,
                        "UTF-8"
                    ) + "&"
                            + URLEncoder.encode(
                        "password",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(password, "UTF-8"))
                bufferedWriter.write(post_data)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream : InputStream= httpUrlConnection.inputStream
                val bufferedReader =
                    BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var result:String=""
                var line : String=bufferedReader.readLine()
                while(line!=null) {
                    result += line
                    line=bufferedReader.readLine()
                }
                bufferedReader.close()
                inputStream.close()
                httpUrlConnection.disconnect()

                return result

            }catch (e :MalformedURLException){
                e.printStackTrace()

            }catch (e: IOException){
                e.printStackTrace()
            }

        }
        return null
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }
    override fun onPostExecute(result: String?) {
        print(result)
        super.onPostExecute(result.toString())
    }
    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }
}
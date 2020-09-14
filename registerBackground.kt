package com.example.travelbook

import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class registerBackground : AsyncTask<String, Void, String>() {


    override fun doInBackground(vararg params: String?): String? {
        var type = params[0]
        var name = params[1]
        var email = params[2]
        var password = params[3]
        var mobile = params[4]
        val register_url = "http://192.168.1.11/register.php"
        if(type=="register"){
            try{
                val url = URL(register_url)
                val httpUrlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
                httpUrlConnection.requestMethod = "POST"
                httpUrlConnection.doOutput = true
                httpUrlConnection.doInput = true
                val outputStream : OutputStream = httpUrlConnection.outputStream
                val bufferedWriter =
                    BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data: String =
                    ((URLEncoder.encode("user_name", "UTF-8").toString() + "=" + URLEncoder.encode(
                        name,
                        "UTF-8"
                    ) + "&"+(URLEncoder.encode("user_email", "UTF-8").toString() + "=" + URLEncoder.encode(
                        email,
                        "UTF-8"
                    ) + "&"+(URLEncoder.encode("user_password", "UTF-8").toString() + "=" + URLEncoder.encode(
                        password,
                        "UTF-8"
                    ) + "&"
                            + URLEncoder.encode("user_mobile","UTF-8" ).toInt() + "=" + URLEncoder.encode(mobile
                        , "UTF-8")))))
                bufferedWriter.write(post_data)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream : InputStream = httpUrlConnection.inputStream
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

            }catch (e : MalformedURLException){
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
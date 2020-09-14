package com.example.travelbook

import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class BookingBackground : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String?): String? {
        var type = params[0]
        var roomtype = params[1]
        var noGuests = params[2]
        var indate= params[3]
        var outdate = params[4]
        val login_url = "http://192.168.1.11/update.php"
        val book_url = "http://192.168.1.11/book.php"
        if(type=="modify"){
            try{
                val url = URL(login_url)
                val httpUrlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
                httpUrlConnection.requestMethod = "POST"
                httpUrlConnection.doOutput = true
                httpUrlConnection.doInput = true
                val outputStream : OutputStream = httpUrlConnection.outputStream
                val bufferedWriter =
                    BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data: String =
                    (URLEncoder.encode("room_type", "UTF-8").toString() + "=" + URLEncoder.encode(
                        roomtype,
                        "UTF-8"
                    ) + "&"
                            + URLEncoder.encode(
                        "Capacity",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(noGuests, "UTF-8")+ "&"
                            + URLEncoder.encode(
                        "InDate",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(indate, "UTF-8")
                            )
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

        }else if(type=="book"){
            try{
                val url = URL(book_url)
                val httpUrlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
                httpUrlConnection.requestMethod = "POST"
                httpUrlConnection.doOutput = true
                httpUrlConnection.doInput = true
                val outputStream : OutputStream = httpUrlConnection.outputStream
                val bufferedWriter =
                    BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data: String =
                    (URLEncoder.encode("room_type", "UTF-8").toString() + "=" + URLEncoder.encode(
                        roomtype,
                        "UTF-8"
                    ) + "&"
                            + URLEncoder.encode(
                        "capacity",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(noGuests, "UTF-8")+ "&"
                            + URLEncoder.encode(
                        "inDate",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(indate, "UTF-8")+ "&"
                            + URLEncoder.encode(
                        "outDate",
                        "UTF-8"
                    ) + "=" + URLEncoder.encode(outdate, "UTF-8")
                            )
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
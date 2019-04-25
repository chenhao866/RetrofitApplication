package com.zzas.retrofitapplication;

import java.util.List;

public class WeatherEntity {
    public resultBean getResult() {
        return result;
    }

    public void setResult(resultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private resultBean result;
    private int error_code;
    private String reason;
    //创建resultBean
    public static class resultBean{
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public realtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(realtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<futureBean> getFuture() {
            return future;
        }

        public void setFuture(List<futureBean> future) {
            this.future = future;
        }

        private String city;
        private realtimeBean realtime;
        private List<futureBean> future;//因为它包含多条数据所以类型为list
        //创建realtimeBean
        public static class realtimeBean{
            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

        }
        //创建futureBean
        public static class futureBean{
            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public widBean getWid() {
                return wid;
            }

            public void setWid(widBean wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            private String date;
            private String temperature;
            private String weather;
            private widBean wid;
            private String direct;
            //创建widBean
            public static class widBean{
                private String day;
                private String night;
            }
        }
    }
}

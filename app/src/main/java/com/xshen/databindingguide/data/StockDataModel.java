package com.xshen.databindingguide.data;

import java.util.List;

/**
 * 说明：数据模型
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-06-07 14:26
 */
public class StockDataModel {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"stockinfo":[{"name":"中信国安","code":"sz000839","date":"2016-06-07","time":"14:25:12","OpenningPrice":19,"closingPrice":18.97,"currentPrice":18.94,"hPrice":19.08,"lPrice":18.78,"competitivePrice":18.94,"auctionPrice":18.95,"totalNumber":31886913,"turnover":603350263,"increase":-0.15814443858723,"buyOne":17344,"buyOnePrice":18.94,"buyTwo":16119,"buyTwoPrice":18.93,"buyThree":24284,"buyThreePrice":18.92,"buyFour":16100,"buyFourPrice":18.91,"buyFive":31742,"buyFivePrice":18.9,"sellOne":1300,"sellOnePrice":18.95,"sellTwo":51404,"sellTwoPrice":18.96,"sellThree":53300,"sellThreePrice":18.97,"sellFour":103679,"sellFourPrice":18.98,"sellFive":98100,"sellFivePrice":18.99,"minurl":"http://image.sinajs.cn/newchart/min/n/sz000839.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sz000839.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sz000839.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sz000839.gif"}],"market":{"shanghai":{"name":"上证指数","curdot":2933.3068,"curprice":-0.7911,"rate":-0.03,"dealnumber":1071698,"turnover":13078605},"shenzhen":{"name":"深证成指","curdot":10336.36,"curprice":-26.727,"rate":-0.26,"dealnumber":164630885,"turnover":28485431},"DJI":{"name":"道琼斯","date":"2016-06-07 07:33:05","curdot":17920.33,"rate":0.64,"growth":113.27,"startdot":17825.69,"closedot":17807.06,"hdot":17949.68,"ldot":17822.81,"turnover":0},"IXIC":{"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":4968.71,"rate":0.53,"growth":26.2,"startdot":4950.46,"closedot":4942.52,"hdot":4980.14,"ldot":4944.87,"turnover":1627655296},"INX":{"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":2109.41,"rate":0.49,"growth":10.28,"startdot":2100.83,"closedot":2099.13,"hdot":2113.36,"ldot":2100.83,"turnover":0},"HSI":{"name":"恒生指数","date":"2016/06/07 14:23","curdot":21211.79,"rate":0.86,"growth":181.57,"startdot":21218.96,"closedot":21030.22,"hdot":21260.54,"ldot":21153.68,"turnover":43541509,"52hdot":27470.5,"52ldot":18278.8}}}
     */

    private int errNum;
    private String errMsg;
    /**
     * stockinfo : [{"name":"中信国安","code":"sz000839","date":"2016-06-07","time":"14:25:12","OpenningPrice":19,"closingPrice":18.97,"currentPrice":18.94,"hPrice":19.08,"lPrice":18.78,"competitivePrice":18.94,"auctionPrice":18.95,"totalNumber":31886913,"turnover":603350263,"increase":-0.15814443858723,"buyOne":17344,"buyOnePrice":18.94,"buyTwo":16119,"buyTwoPrice":18.93,"buyThree":24284,"buyThreePrice":18.92,"buyFour":16100,"buyFourPrice":18.91,"buyFive":31742,"buyFivePrice":18.9,"sellOne":1300,"sellOnePrice":18.95,"sellTwo":51404,"sellTwoPrice":18.96,"sellThree":53300,"sellThreePrice":18.97,"sellFour":103679,"sellFourPrice":18.98,"sellFive":98100,"sellFivePrice":18.99,"minurl":"http://image.sinajs.cn/newchart/min/n/sz000839.gif","dayurl":"http://image.sinajs.cn/newchart/daily/n/sz000839.gif","weekurl":"http://image.sinajs.cn/newchart/weekly/n/sz000839.gif","monthurl":"http://image.sinajs.cn/newchart/monthly/n/sz000839.gif"}]
     * market : {"shanghai":{"name":"上证指数","curdot":2933.3068,"curprice":-0.7911,"rate":-0.03,"dealnumber":1071698,"turnover":13078605},"shenzhen":{"name":"深证成指","curdot":10336.36,"curprice":-26.727,"rate":-0.26,"dealnumber":164630885,"turnover":28485431},"DJI":{"name":"道琼斯","date":"2016-06-07 07:33:05","curdot":17920.33,"rate":0.64,"growth":113.27,"startdot":17825.69,"closedot":17807.06,"hdot":17949.68,"ldot":17822.81,"turnover":0},"IXIC":{"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":4968.71,"rate":0.53,"growth":26.2,"startdot":4950.46,"closedot":4942.52,"hdot":4980.14,"ldot":4944.87,"turnover":1627655296},"INX":{"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":2109.41,"rate":0.49,"growth":10.28,"startdot":2100.83,"closedot":2099.13,"hdot":2113.36,"ldot":2100.83,"turnover":0},"HSI":{"name":"恒生指数","date":"2016/06/07 14:23","curdot":21211.79,"rate":0.86,"growth":181.57,"startdot":21218.96,"closedot":21030.22,"hdot":21260.54,"ldot":21153.68,"turnover":43541509,"52hdot":27470.5,"52ldot":18278.8}}
     */

    private RetDataEntity retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public static class RetDataEntity {
        /**
         * shanghai : {"name":"上证指数","curdot":2933.3068,"curprice":-0.7911,"rate":-0.03,"dealnumber":1071698,"turnover":13078605}
         * shenzhen : {"name":"深证成指","curdot":10336.36,"curprice":-26.727,"rate":-0.26,"dealnumber":164630885,"turnover":28485431}
         * DJI : {"name":"道琼斯","date":"2016-06-07 07:33:05","curdot":17920.33,"rate":0.64,"growth":113.27,"startdot":17825.69,"closedot":17807.06,"hdot":17949.68,"ldot":17822.81,"turnover":0}
         * IXIC : {"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":4968.71,"rate":0.53,"growth":26.2,"startdot":4950.46,"closedot":4942.52,"hdot":4980.14,"ldot":4944.87,"turnover":1627655296}
         * INX : {"name":"纳斯达克","date":"2016-06-07 05:40:00","curdot":2109.41,"rate":0.49,"growth":10.28,"startdot":2100.83,"closedot":2099.13,"hdot":2113.36,"ldot":2100.83,"turnover":0}
         * HSI : {"name":"恒生指数","date":"2016/06/07 14:23","curdot":21211.79,"rate":0.86,"growth":181.57,"startdot":21218.96,"closedot":21030.22,"hdot":21260.54,"ldot":21153.68,"turnover":43541509,"52hdot":27470.5,"52ldot":18278.8}
         */

        private MarketEntity market;
        /**
         * name : 中信国安
         * code : sz000839
         * date : 2016-06-07
         * time : 14:25:12
         * OpenningPrice : 19
         * closingPrice : 18.97
         * currentPrice : 18.94
         * hPrice : 19.08
         * lPrice : 18.78
         * competitivePrice : 18.94
         * auctionPrice : 18.95
         * totalNumber : 31886913
         * turnover : 603350263
         * increase : -0.15814443858723
         * buyOne : 17344
         * buyOnePrice : 18.94
         * buyTwo : 16119
         * buyTwoPrice : 18.93
         * buyThree : 24284
         * buyThreePrice : 18.92
         * buyFour : 16100
         * buyFourPrice : 18.91
         * buyFive : 31742
         * buyFivePrice : 18.9
         * sellOne : 1300
         * sellOnePrice : 18.95
         * sellTwo : 51404
         * sellTwoPrice : 18.96
         * sellThree : 53300
         * sellThreePrice : 18.97
         * sellFour : 103679
         * sellFourPrice : 18.98
         * sellFive : 98100
         * sellFivePrice : 18.99
         * minurl : http://image.sinajs.cn/newchart/min/n/sz000839.gif
         * dayurl : http://image.sinajs.cn/newchart/daily/n/sz000839.gif
         * weekurl : http://image.sinajs.cn/newchart/weekly/n/sz000839.gif
         * monthurl : http://image.sinajs.cn/newchart/monthly/n/sz000839.gif
         */

        private List<StockinfoEntity> stockinfo;

        public MarketEntity getMarket() {
            return market;
        }

        public void setMarket(MarketEntity market) {
            this.market = market;
        }

        public List<StockinfoEntity> getStockinfo() {
            return stockinfo;
        }

        public void setStockinfo(List<StockinfoEntity> stockinfo) {
            this.stockinfo = stockinfo;
        }

        public static class MarketEntity {
            /**
             * name : 上证指数
             * curdot : 2933.3068
             * curprice : -0.7911
             * rate : -0.03
             * dealnumber : 1071698
             * turnover : 13078605
             */

            private ShanghaiEntity shanghai;
            /**
             * name : 深证成指
             * curdot : 10336.36
             * curprice : -26.727
             * rate : -0.26
             * dealnumber : 164630885
             * turnover : 28485431
             */

            private ShenzhenEntity shenzhen;
            /**
             * name : 道琼斯
             * date : 2016-06-07 07:33:05
             * curdot : 17920.33
             * rate : 0.64
             * growth : 113.27
             * startdot : 17825.69
             * closedot : 17807.06
             * hdot : 17949.68
             * ldot : 17822.81
             * turnover : 0
             */

            private DJIEntity DJI;
            /**
             * name : 纳斯达克
             * date : 2016-06-07 05:40:00
             * curdot : 4968.71
             * rate : 0.53
             * growth : 26.2
             * startdot : 4950.46
             * closedot : 4942.52
             * hdot : 4980.14
             * ldot : 4944.87
             * turnover : 1627655296
             */

            private IXICEntity IXIC;
            /**
             * name : 纳斯达克
             * date : 2016-06-07 05:40:00
             * curdot : 2109.41
             * rate : 0.49
             * growth : 10.28
             * startdot : 2100.83
             * closedot : 2099.13
             * hdot : 2113.36
             * ldot : 2100.83
             * turnover : 0
             */

            private INXEntity INX;
            /**
             * name : 恒生指数
             * date : 2016/06/07 14:23
             * curdot : 21211.79
             * rate : 0.86
             * growth : 181.57
             * startdot : 21218.96
             * closedot : 21030.22
             * hdot : 21260.54
             * ldot : 21153.68
             * turnover : 43541509
             * 52hdot : 27470.5
             * 52ldot : 18278.8
             */

            private HSIEntity HSI;

            public ShanghaiEntity getShanghai() {
                return shanghai;
            }

            public void setShanghai(ShanghaiEntity shanghai) {
                this.shanghai = shanghai;
            }

            public ShenzhenEntity getShenzhen() {
                return shenzhen;
            }

            public void setShenzhen(ShenzhenEntity shenzhen) {
                this.shenzhen = shenzhen;
            }

            public DJIEntity getDJI() {
                return DJI;
            }

            public void setDJI(DJIEntity DJI) {
                this.DJI = DJI;
            }

            public IXICEntity getIXIC() {
                return IXIC;
            }

            public void setIXIC(IXICEntity IXIC) {
                this.IXIC = IXIC;
            }

            public INXEntity getINX() {
                return INX;
            }

            public void setINX(INXEntity INX) {
                this.INX = INX;
            }

            public HSIEntity getHSI() {
                return HSI;
            }

            public void setHSI(HSIEntity HSI) {
                this.HSI = HSI;
            }

            public static class ShanghaiEntity {
                private String name;
                private double curdot;
                private double curprice;
                private double rate;
                private int dealnumber;
                private long turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getCurprice() {
                    return curprice;
                }

                public void setCurprice(double curprice) {
                    this.curprice = curprice;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public int getDealnumber() {
                    return dealnumber;
                }

                public void setDealnumber(int dealnumber) {
                    this.dealnumber = dealnumber;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }
            }

            public static class ShenzhenEntity {
                private String name;
                private double curdot;
                private double curprice;
                private double rate;
                private int dealnumber;
                private long turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getCurprice() {
                    return curprice;
                }

                public void setCurprice(double curprice) {
                    this.curprice = curprice;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public int getDealnumber() {
                    return dealnumber;
                }

                public void setDealnumber(int dealnumber) {
                    this.dealnumber = dealnumber;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }
            }

            public static class DJIEntity {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private long turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }
            }

            public static class IXICEntity {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private long turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }
            }

            public static class INXEntity {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private long turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }
            }

            public static class HSIEntity {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private long turnover;
                @com.google.gson.annotations.SerializedName("52hdot")
                private double value52hdot;
                @com.google.gson.annotations.SerializedName("52ldot")
                private double value52ldot;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public long getTurnover() {
                    return turnover;
                }

                public void setTurnover(long turnover) {
                    this.turnover = turnover;
                }

                public double getValue52hdot() {
                    return value52hdot;
                }

                public void setValue52hdot(double value52hdot) {
                    this.value52hdot = value52hdot;
                }

                public double getValue52ldot() {
                    return value52ldot;
                }

                public void setValue52ldot(double value52ldot) {
                    this.value52ldot = value52ldot;
                }
            }
        }

        public static class StockinfoEntity {
            private String name;
            private String code;
            private String date;
            private String time;
            private double OpenningPrice;
            private double closingPrice;
            private double currentPrice;
            private double hPrice;
            private double lPrice;
            private double competitivePrice;
            private double auctionPrice;
            private long totalNumber;
            private long turnover;
            private double increase;
            private int buyOne;
            private double buyOnePrice;
            private int buyTwo;
            private double buyTwoPrice;
            private int buyThree;
            private double buyThreePrice;
            private int buyFour;
            private double buyFourPrice;
            private int buyFive;
            private double buyFivePrice;
            private int sellOne;
            private double sellOnePrice;
            private int sellTwo;
            private double sellTwoPrice;
            private int sellThree;
            private double sellThreePrice;
            private int sellFour;
            private double sellFourPrice;
            private int sellFive;
            private double sellFivePrice;
            private String minurl;
            private String dayurl;
            private String weekurl;
            private String monthurl;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public double getOpenningPrice() {
                return OpenningPrice;
            }

            public void setOpenningPrice(double OpenningPrice) {
                this.OpenningPrice = OpenningPrice;
            }

            public double getClosingPrice() {
                return closingPrice;
            }

            public void setClosingPrice(double closingPrice) {
                this.closingPrice = closingPrice;
            }

            public double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public double getHPrice() {
                return hPrice;
            }

            public void setHPrice(double hPrice) {
                this.hPrice = hPrice;
            }

            public double getLPrice() {
                return lPrice;
            }

            public void setLPrice(double lPrice) {
                this.lPrice = lPrice;
            }

            public double getCompetitivePrice() {
                return competitivePrice;
            }

            public void setCompetitivePrice(double competitivePrice) {
                this.competitivePrice = competitivePrice;
            }

            public double getAuctionPrice() {
                return auctionPrice;
            }

            public void setAuctionPrice(double auctionPrice) {
                this.auctionPrice = auctionPrice;
            }

            public long getTotalNumber() {
                return totalNumber;
            }

            public void setTotalNumber(long totalNumber) {
                this.totalNumber = totalNumber;
            }

            public long getTurnover() {
                return turnover;
            }

            public void setTurnover(long turnover) {
                this.turnover = turnover;
            }

            public double getIncrease() {
                return increase;
            }

            public void setIncrease(double increase) {
                this.increase = increase;
            }

            public int getBuyOne() {
                return buyOne;
            }

            public void setBuyOne(int buyOne) {
                this.buyOne = buyOne;
            }

            public double getBuyOnePrice() {
                return buyOnePrice;
            }

            public void setBuyOnePrice(double buyOnePrice) {
                this.buyOnePrice = buyOnePrice;
            }

            public int getBuyTwo() {
                return buyTwo;
            }

            public void setBuyTwo(int buyTwo) {
                this.buyTwo = buyTwo;
            }

            public double getBuyTwoPrice() {
                return buyTwoPrice;
            }

            public void setBuyTwoPrice(double buyTwoPrice) {
                this.buyTwoPrice = buyTwoPrice;
            }

            public int getBuyThree() {
                return buyThree;
            }

            public void setBuyThree(int buyThree) {
                this.buyThree = buyThree;
            }

            public double getBuyThreePrice() {
                return buyThreePrice;
            }

            public void setBuyThreePrice(double buyThreePrice) {
                this.buyThreePrice = buyThreePrice;
            }

            public int getBuyFour() {
                return buyFour;
            }

            public void setBuyFour(int buyFour) {
                this.buyFour = buyFour;
            }

            public double getBuyFourPrice() {
                return buyFourPrice;
            }

            public void setBuyFourPrice(double buyFourPrice) {
                this.buyFourPrice = buyFourPrice;
            }

            public int getBuyFive() {
                return buyFive;
            }

            public void setBuyFive(int buyFive) {
                this.buyFive = buyFive;
            }

            public double getBuyFivePrice() {
                return buyFivePrice;
            }

            public void setBuyFivePrice(double buyFivePrice) {
                this.buyFivePrice = buyFivePrice;
            }

            public int getSellOne() {
                return sellOne;
            }

            public void setSellOne(int sellOne) {
                this.sellOne = sellOne;
            }

            public double getSellOnePrice() {
                return sellOnePrice;
            }

            public void setSellOnePrice(double sellOnePrice) {
                this.sellOnePrice = sellOnePrice;
            }

            public int getSellTwo() {
                return sellTwo;
            }

            public void setSellTwo(int sellTwo) {
                this.sellTwo = sellTwo;
            }

            public double getSellTwoPrice() {
                return sellTwoPrice;
            }

            public void setSellTwoPrice(double sellTwoPrice) {
                this.sellTwoPrice = sellTwoPrice;
            }

            public int getSellThree() {
                return sellThree;
            }

            public void setSellThree(int sellThree) {
                this.sellThree = sellThree;
            }

            public double getSellThreePrice() {
                return sellThreePrice;
            }

            public void setSellThreePrice(double sellThreePrice) {
                this.sellThreePrice = sellThreePrice;
            }

            public int getSellFour() {
                return sellFour;
            }

            public void setSellFour(int sellFour) {
                this.sellFour = sellFour;
            }

            public double getSellFourPrice() {
                return sellFourPrice;
            }

            public void setSellFourPrice(double sellFourPrice) {
                this.sellFourPrice = sellFourPrice;
            }

            public int getSellFive() {
                return sellFive;
            }

            public void setSellFive(int sellFive) {
                this.sellFive = sellFive;
            }

            public double getSellFivePrice() {
                return sellFivePrice;
            }

            public void setSellFivePrice(double sellFivePrice) {
                this.sellFivePrice = sellFivePrice;
            }

            public String getMinurl() {
                return minurl;
            }

            public void setMinurl(String minurl) {
                this.minurl = minurl;
            }

            public String getDayurl() {
                return dayurl;
            }

            public void setDayurl(String dayurl) {
                this.dayurl = dayurl;
            }

            public String getWeekurl() {
                return weekurl;
            }

            public void setWeekurl(String weekurl) {
                this.weekurl = weekurl;
            }

            public String getMonthurl() {
                return monthurl;
            }

            public void setMonthurl(String monthurl) {
                this.monthurl = monthurl;
            }
        }
    }
}

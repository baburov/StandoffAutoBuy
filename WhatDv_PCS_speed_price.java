Image selected_price_1 = Image.load("one_with_point");
Image selected_price_2 = Image.load("one_with_zero");

var priceL = Point.get(1750, 562);
var priceR = Point.get(1844, 610);
var priceL2 = Point.get(1750, 562 + 144);
var priceR2 = Point.get(1844, 610 + 144);

var viewExit = Point.get(304, 951);

var error = Point.get(1357, 752);
int errorColor = 9992742;

var buy = Point.get(2240,569);

var confirm = Point.get(1197,748);

var upd = Point.get(1002,463);

int slotH = 144;

int slotA = 3;

int updColor = 6381138;

startScreenCapture(2);
setMinMatchQuality(97); 
sleep(5);
long kdtime = Time.getMillis();
long bufTime = 0;
long slpS = 1500;
long secItter = 0;
int updErrorFlag = 0;
for (;;)
{ 
        if (hasImg(selected_price_1, priceL, priceR) && getColor(buy.x, buy.y) < 11077777)
        {
                click(buy.x, buy.y);  
                sleep(15);
                clickRand(confirm, 0);
                sleep(500);
                log("try buy 1› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        if (hasImg(selected_price_1, priceL2, priceR2) && getColor(buy.x, buy.y + 144) < 11077777)
        {
                click(buy.x, buy.y + 144);  
                sleep(15);
                clickRand(confirm, 0);
                sleep(500);
                log("try buy 2› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        if (getColor(error.x, error.y) < 11077777)
        {
                clickRand(confirm, 0);
                sleep(50);
                log("error buy 1› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        bufTime = (Time.getMillis() - kdtime) / slpS;
        if (bufTime != secItter && (getColor(buy.x, buy.y) > 14000000 || bufTime % 8 == 0))
        {
            secItter = bufTime;
            sleep(50);
            clickRand(upd, 0);
            sleep(50);
            clickRand(upd, 0);
            sleep(50);
            if (getColor(upd.x, upd.y) < 10000000)
            {
                    secItter = bufTime;
                    sleep(50);
                    clickRand(upd, 0);
                    log("upd bug › "+Time.getTime());
            }
            click(viewExit.x, viewExit.y); 
            sleep(50);
        }
}

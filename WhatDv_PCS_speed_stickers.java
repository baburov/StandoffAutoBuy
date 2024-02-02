int stickCount = 2;
int stickSize = 52;

var viewExit = Point.get(304, 951);

var error = Point.get(1357, 752);
int errorColor = 9992742;

var stickL = Point.get(1505,586);

var stickR = Point.get(1495 + stickSize/2 - 10 + stickSize * (4 - stickCount),602);

var stickL2 = Point.get(1473,581 + 144);
var stickR2 = Point.get(1495 + stickSize/2 - 10 + stickSize * (4 - stickCount),602 + 144);

var buy = Point.get(2240,569);

var confirm = Point.get(1197,748);

var upd = Point.get(1002,463);

int slotH = 144;

int slotA = 3;

int updColor = 6381138;

startScreenCapture(2);
sleep(5);
long kdtime = Time.getMillis();
long speedTime = 0;
long bufTime = 0;
long slpS = 2000;
long secItter = 0;
int updErrorFlag = 0;
int errorCount = 0;
int buyCount = 0;
int winRate = 0;
for (;;)
{ 
        speedTime = Time.getMillis();
        if (getContoursCount (stickL, stickR) > 2 && getColor(buy.x, buy.y) < 11077777)
        {
                click(buy.x, buy.y);
clickRand(confirm, 0);  
                clickRand(confirm, 0);
                sleep(5);
                clickRand(confirm, 0);
                speedTime = Time.getMillis() - speedTime;
                sleep(500);
                log("try buy 1› "+Time.getTime() + " speed: " + speedTime + "ms");
                buyCount++;
                winRate = ((buyCount - errorCount) / buyCount * 100);
                log("win rate › " + winRate + "%");
                
                click(viewExit.x, viewExit.y);
                sleep(50);
        }
        speedTime = Time.getMillis();
        if (getContoursCount (stickL2, stickR2) > 2 && getColor(buy.x, buy.y + slotH) < 11077777)
        {
                click(buy.x, buy.y + slotH);  
clickRand(confirm, 0);
                clickRand(confirm, 0);
                sleep(5);
                clickRand(confirm, 0);
                speedTime = Time.getMillis() - speedTime;
                sleep(500);
                log("try buy 2› "+Time.getTime() + " speed: " + speedTime + "ms");
                buyCount++;
                winRate = ((buyCount - errorCount) / buyCount * 100);
                log("win rate › " + winRate + "%");
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        if (getColor(error.x, error.y) < 11077777)
        {
                clickRand(confirm, 0);
                sleep(50);
                log("error buy 1› "+Time.getTime());
                if (buyCount != 0)
                        errorCount++;
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        bufTime = (Time.getMillis() - kdtime) / slpS;
        if (bufTime != secItter && (getColor(buy.x, buy.y) > 14000000 || bufTime % 12 == 0))
        {
            secItter = bufTime;
          
            clickRand(upd, 0);
            sleep(200);
            clickRand(upd, 0);
            sleep(100);
            click(viewExit.x, viewExit.y); 
            sleep(50);
        }
bufTime = (Time.getMillis() - kdtime) / slpS;
        if (bufTime != secItter && getColor(upd.x, upd.y) < 10000000)
        {
                    secItter = bufTime;
                    clickRand(upd, 0);
                    //log("upd bug › "+Time.getTime());
        }
}

package com.test.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

//https://www.cnblogs.com/weilunhui/p/3857366.html
//http://www.ibloger.net/article/2329.html

public class JsonPathUtil {

    public static void main(String[] args) {
        String str = "[{\"name\":\"instance_123.3.3.128_6381\",\"columns\":[\"time\",\"sequence_number\",\"used_memory\"],\"points\":[[1537842222879,1600705997640001,3747587040],[1537842213137,1600705558530001,3747473808],[1537842192936,1600704757680001,3747956160],[1537842183122,1600704315220001,3747937352],[1537842162830,1600703514310001,3748721600],[1537842153157,1600703072200001,3749128072],[1537842132826,1600702271670001,3750086776],[1537842123158,1600701831290001,3749702240],[1537842102824,1600701032330001,3749653200],[1537842093185,1600700588120001,3749229272],[1537842072826,1600699790110001,3749070328],[1537842063204,1600699362730001,3748703232],[1537842042855,1600698553010001,3748080120],[1537842033127,1600698129040001,3748356784],[1537842012819,1600697310220001,3747607320],[1537842003066,1600696886680001,3747939088],[1537841982816,1600696067030001,3749137752],[1537841973044,1600695655830001,3748808136],[1537841952810,1600694833500001,3749841640],[1537841943065,1600694412430001,3749642936],[1537841922808,1600693590070001,3749157816],[1537841913129,1600693169250001,3748877160],[1537841892959,1600692348690001,3749052208],[1537841883044,1600691928600001,3748907272],[1537841862802,1600691108240001,3749616784],[1537841853025,1600690685330001,3749544488],[1537841832800,1600689865190001,3750091000],[1537841823118,1600689442300001,3749931272],[1537841802939,1600688621850001,3749557128],[1537841793327,1600688215650001,3749024328],[1537841772796,1600687379280001,3747727136],[1537841763302,1600686978490001,3747653360],[1537841742804,1600686136600001,3746460424],[1537841733183,1600685735380001,3746277504],[1537841712924,1600684893740001,3746173160],[1537841703019,1600684494600001,3746343680],[1537841682794,1600683658060001,3746604984],[1537841673203,1600683257440001,3746638824],[1537841652788,1600682415080001,3747272496],[1537841643016,1600682014650001,3747531424],[1537841622793,1600681171890001,3747373328],[1537841613008,1600680771540001,3747702872],[1537841592787,1600679952400001,3747364720],[1537841583005,1600679542470001,3747354184],[1537841562817,1600678714870001,3747607064],[1537841552964,1600678300620001,3747793312],[1537841532788,1600677472860001,3747630080],[1537841523041,1600677057460001,3748022864],[1537841502783,1600676230040001,3747743976],[1537841492927,1600675820490001,3748372464],[1537841472776,1600674986890001,3748607992],[1537841463296,1600674591880001,3748356256],[1537841442770,1600673744430001,3747903152],[1537841432941,1600673349830001,3747590216],[1537841412770,1600672503830001,3747522296],[1537841402931,1600672108160001,3747578208],[1537841382775,1600671265280001,3747409240],[1537841373091,1600670872750001,3748152232],[1537841352766,1600670022060001,3749480624],[1537841342908,1600669629200001,3749322824],[1537841322770,1600668787170001,3750006304],[1537841312940,1600668394600001,3750155752],[1537841293002,1600667567570001,3750261984],[1537841282708,1600667148220001,3749758328],[1537841262959,1600666343790001,3749862280],[1537841252703,1600665921520001,3749952048],[1537841232907,1600665102180001,3748694048],[1537841222703,1600664678140001,3748146264],[1537841202954,1600663862290001,3748004272],[1537841192708,1600663437370001,3748015032],[1537841173072,1600662625960001,3748314448],[1537841162768,1600662204880001,3748204432],[1537841142937,1600661382720001,3748758824],[1537841133059,1600660965060001,3749338176],[1537841112864,1600660141360001,3749751248],[1537841102710,1600659723310001,3749751592],[1537841082912,1600658909460001,3749853032],[1537841072823,1600658488690001,3750028608],[1537841053104,1600657668950001,3750268696],[1537841042824,1600657248940001,3750282816],[1537841022955,1600656438380001,3750324680],[1537841012671,1600656020280001,3749918696],[1537840993029,1600655209580001,3750214568],[1537840982643,1600654776770001,3748948304],[1537840963170,1600653971460001,3749632784],[1537840952685,1600653537970001,3748890096],[1537840932811,1600652730810001,3749920128],[1537840922767,1600652297480001,3749742688],[1537840902831,1600651487360001,3749517736],[1537840892993,1600651083500001,3749915928],[1537840873005,1600650252300001,3750050448],[1537840863118,1600649848310001,3750448520],[1537840842823,1600649012080001,3751630080],[1537840812795,1600647780750001,3751901936],[1537840802769,1600647381970001,3751646520],[1537840782870,1600646547740001,3750147824],[1537840772789,1600646146650001,3748573088],[1537840752871,1600645311860001,3747413448],[1537840742798,1600644909740001,3747678296],[1537840722755,1600644069990001,3747685320],[1537840712734,1600643668100001,3747448224],[1537840692886,1600642841260001,3747581168],[1537840682830,1600642426940001,3747838384],[1537840662883,1600641599520001,3747678304],[1537840652832,1600641183570001,3747514280],[1537840632726,1600640356300001,3748345168],[1537840622623,1600639940250001,3748560344],[1537840602855,1600639112900001,3747856312],[1537840592760,1600638711450001,3747828512],[1537840573141,1600637871020001,3747355712],[1537840563015,1600637471560001,3747220008],[1537840542734,1600636629490001,3746825560],[1537840532997,1600636230150001,3746643416],[1537840512741,1600635386430001,3746452808],[1537840502684,1600634986970001,3746407640],[1537840482715,1600634152630001,3746483752],[1537840472613,1600633753630001,3746972968],[1537840452713,1600632909590001,3748115936],[1537840442639,1600632511490001,3747553048],[1537840423115,1600631666250001,3747102880],[1537840412583,1600631268970001,3746712968],[1537840392750,1600630430380001,3746686360],[1537840382875,1600630026710001,3747081344],[1537840362822,1600629187080001,3746991264],[1537840352582,1600628784490001,3747184928],[1537840332704,1600627953940001,3747188768],[1537840322560,1600627551120001,3746797760],[1537840302702,1600626713510001,3747213696],[1537840292563,1600626308640001,3746850128],[1537840272700,1600625483010001,3747878592],[1537840262817,1600625079460001,3748705712],[1537840242910,1600624251560001,3750171144],[1537840232594,1600623848240001,3749961440],[1537840212732,1600623008830001,3750577584],[1537840202560,1600622605790001,3749848592],[1537840182695,1600621777190001,3747916968],[1537840172596,1600621371710001,3747272936],[1537840152913,1600620575400001,3744980096],[1537840142660,1600620168120001,3744684392],[1537840123066,1600619343140001,3744934552],[1537840112703,1600618946650001,3744399432],[1537840092987,1600618124910001,3744589480],[1537840082723,1600617715150001,3745012472],[1537840062920,1600616895800001,3745903784],[1537840052674,1600616493420001,3746182384],[1537840032970,1600615692190001,3746471464],[1537840022741,1600615264190001,3746369128],[1537840002681,1600614471130001,3746194368],[1537839992724,1600614057290001,3745527200],[1537839972678,1600613249450001,3745004888],[1537839962786,1600612851230001,3744767888],[1537839942983,1600612037090001,3744914624],[1537839932636,1600611629930001,3744941144],[1537839912773,1600610809030001,3745883032],[1537839902591,1600610404850001,3746104576],[1537839882672,1600609582860001,3746564128],[1537839872653,1600609182440001,3746869304],[1537839852670,1600608360590001,3745660064],[1537839842549,1600607943690001,3745077160],[1537839822746,1600607135480001,3745861832],[1537839812520,1600606703180001,3745832360],[1537839792727,1600605895130001,3746540128],[1537839782565,1600605460000001,3746512216],[1537839762710,1600604652760001,3746022360],[1537839752529,1600604217070001,3745521496],[1537839732677,1600603409800001,3744799488],[1537839722516,1600602975460001,3744899472],[1537839702704,1600602167950001,3745539040],[1537839692696,1600601746360001,3745693976],[1537839672848,1600600929920001,3746382752],[1537839662532,1600600518700001,3746651408],[1537839642684,1600599697240001,3746244296],[1537839632506,1600599276200001,3746593720],[1537839612689,1600598454110001,3746849504],[1537839602654,1600598045970001,3746669544],[1537839583041,1600597224530001,3746523496],[1537839572501,1600596816530001,3747350936],[1537839552986,1600595996540001,3746665528],[1537839542499,1600595580170001,3746311680],[1537839522667,1600594764920001,3746886768],[1537839512513,1600594341870001,3746888296],[1537839492648,1600593523740001,3746941848],[1537839482631,1600593098980001,3747248080],[1537839462658,1600592287240001,3747174432],[1537839452500,1600591860000001,3746647712],[1537839432643,1600591045710001,3746306744],[1537839422497,1600590616920001,3746372792],[1537839402719,1600589807920001,3745893256],[1537839392914,1600589390510001,3746158456],[1537839372666,1600588567410001,3746618808],[1537839362751,1600588150240001,3746604224],[1537839342699,1600587324200001,3746778072],[1537839332569,1600586915520001,3746643112],[1537839312916,1600586089810001,3746987984],[1537839302480,1600585679020001,3746828304],[1537839282668,1600584855660001,3746173704],[1537839272478,1600584435690001,3746266576],[1537839252678,1600583613650001,3747344704],[1537839242780,1600583194390001,3747553512],[1537839222443,1600582363560001,3747665800],[1537839212474,1600581963580001,3748031792],[1537839192873,1600581154610001,3747771360],[1537839182471,1600580729330001,3747936184],[1537839162470,1600579920100001,3747684528],[1537839152469,1600579486020001,3747180232],[1537839132512,1600578676980001,3746144872],[1537839122467,1600578242760001,3745652424],[1537839102449,1600577434270001,3745530864],[1537839092628,1600577008250001,3745055328],[1537839072391,1600576201900001,3745273152],[1537839062465,1600575778790001,3745615808],[1537839042382,1600574958490001,3745635968],[1537839032585,1600574535590001,3745483216],[1537839012700,1600573716710001,3744982392],[1537839002439,1600573291630001,3745132536],[1537838982369,1600572473330001,3745330472],[1537838972434,1600572049790001,3745262672],[1537838952366,1600571230320001,3744835312],[1537838942433,1600570808480001,3745126400],[1537838922366,1600569987830001,3744711584],[1537838912434,1600569567640001,3744632704],[1537838892431,1600568755490001,3744250528],[1537838882408,1600568324450001,3744820216],[1537838862397,1600567512500001,3744973544],[1537838852400,1600567081030001,3745124296],[1537838832407,1600566271900001,3745199432],[1537838822458,1600565842650001,3745026712],[1537838802430,1600565031690001,3745036800],[1537838792395,1600564600040001,3745320544],[1537838772433,1600563789240001,3745210128],[1537838762727,1600563370290001,3745806816],[1537838742411,1600562545920001,3745901408],[1537838732410,1600562135720001,3745837672],[1537838712418,1600561307460001,3745936736],[1537838702596,1600560900300001,3745383328],[1537838682567,1600560071320001,3745225480],[1537838672402,1600559661280001,3745492472],[1537838652416,1600558829190001,3745921360],[1537838642384,1600558418030001,3746047720]]}]";
        DocumentContext context = JsonPath.parse(str);
        long beginTime = 1537842183122L;
        long endTime = 1537838652416L;
        List list = context.read("$.[0].points[?(@.[0]>=" + beginTime + " && @.[0]<=" + endTime + ")].[2]");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

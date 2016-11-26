package com.hyc.fas.db.entity;

import com.hyc.fas.common.SecurityUtil;
import com.hyc.fas.db.PhoneUtil;
import com.hyc.fas.util.TimeUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 19:05
 */
public class UserInfo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println("");
        List<UserInfo> list = genBatchUserInfos(50000);

        for (int i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }


    }


    private String u_i_id;

    private String u_i_type;

    private String real_name;

    private String create_date_time;

    private String phone_v;

    private String ty_id;

    private String ty_cpsid;

    private String pass_word;

    private String phone;

    private String status;





    public static List<UserInfo> genBatchUserInfos(int size) throws UnsupportedEncodingException {
        List<UserInfo> list = new ArrayList<>(size);
        List<String> userIdlist = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            list.add(build(userIdlist));
        }
        return list;
    }


    private final static AtomicInteger atomicInteger = new AtomicInteger(1);

    private static String genUserId() {
        return String.format("%s%08d", TimeUtil.getTime16(),atomicInteger.getAndIncrement());
    }

    private static String[] lastName = "赵、钱、孙、李、周、吴、郑、王、冯、陈、楮、卫、蒋、沈、韩、杨、朱、秦、尤、许、何、吕、施、张、孔、曹、严、华".split("、");
    private static char[] firstName = "欧式的阳台四面透光全落地式的玻璃设计让整个阳台看上去透净而明亮半圆形的空间并不算空旷却还置放着一张香槟色的双人小沙发正是晌午光线充足阳台上的每个角落均一览无遗包括沙发上姿势暧昧的男女咚咚咚咚咚咚顾浅浅听见了这会儿正有人疯了一样地在外头捶着门可压在顾浅浅身上的男人却完全没打算放开她的样子离得这样近她越发地感觉到自己心跳如擂故做镇定的抬眸静静地打量着这个曾经令她痴迷疯狂的男人岁月似乎从不曾在这个男人的身上留下任何的痕迹无论是四年前还是四年后他依然英武不凡俊美得不似人间所有也正是他这种近乎于冰冷的邪美曾几何时让她欲罢不能放开我压低了声音顾浅浅悄悄地磨着牙身子稍一反抗便被陆战北粗鲁地按了回去要是我不呢贴得那样近陆战北鼻尖下缭绕着熟悉的女儿香幽幽地仿若情动时盛开在他身下每一寸颤栗的肌肤只这一个动作顾浅浅的脑子就炸了记忆中的火热痴缠着的那些过往的点滴一点点倒涌回她的记忆里倏地她微凉的指尖被猛地捉住一个扭转双臂已反剪着被他扣在了她的后腰上这样的动作让她被迫挺胸向他胸前风光亦被他一览无遗刚要出声低咒齐膝的裙子却被猛地被他掀起来侧腿的肌肤间亦在同时霸入了一条男人的大长腿他他这混蛋的腿到底朝哪儿伸呢慌乱地抬首恰对上陆战北雪山冰顶般的眸四目相对顾浅浅的心跳快得几差没有蹦出她的嗓子眼淡定淡定眯了眯绝美的黑眸她故做镇定地妖娆一笑小舅舅有话好好说嘛是不是男人的面色不变只腾出那只空余的手直探向她果露在外的冰肌雪颈指下温软的触感滑腻似酥似剥开的荔枝绽放在记忆的最深处在他眼炸开一道道白亮眼前一片昨夜星辰剩下的只有那些旖-旎入髓的画面还有刻进骨子里的疯狂旧事小舅舅她连声音都在抖叫我什么似乎不满男人的眸色渐沉反剪着她的大手故意扣着一扭顾浅浅‘嘶’地一声放开你弄疼我了我还可以让你更疼不记得了么话落男人的大手再度用力顾浅浅只觉得自己的手腕都要被他生生拧下来了刚要失声尖叫男人却突然伸手死死捂住了她的嘴头压下来抵在她耳侧阴侧侧地笑乖你确定真的要叫不她不能门外的挠门声还在不出意外就是她妈要是让她知道她和‘舅舅’在阳台上乱来她妈非急出个脑梗不可所以紧绷着的身体平静下来她用眼神告诉他她绝不会再闹男人会意非常配合地松开了她的嘴可她却迫不急待地喷他一句欺负外甥女你特么还是不是男人舅舅是不是男人外甥女还不清楚话落男人大腿微微一抬竟用膝头爱昧地顶了她一下你下流终于顾浅浅淡定不下去了狂扭着腰肢试图摆脱他的钳制可惜男女有别力量悬殊她折腾了半天却反被他按着颈重重地趴回他身上挣扎不得顾浅浅脑羞成怒索性双手缠上男人的脖子按下他的脑袋在他耳边恶狠狠地吼陆战北你特么到底想干嘛压抑已久的兽性在她的吼声中全部被释放陆战北一个转身便将人反扣在了阳台上干你推高她的裙子扯下那碍眼的黑色无痕从后往前直接男人急促地喘着粗气儿继续着他的动作顾浅浅感觉自己就要死在他身下了迷离之中记忆倒带刹那间似已将她带回了四年前".toCharArray();
    private static String[] statuss = {"01","02","03"};
    private static Random random = new Random();
    public static UserInfo build(List<String> useridList) throws UnsupportedEncodingException {
        String[] phones = PhoneUtil.genPhone("182");
        String userId = genUserId();
        String ty_id = null;
        String ty_cpsId = null;
        if (null != useridList && useridList.isEmpty() == false) {
            if (Integer.parseInt(userId.substring(16)) % 5 == 0) {
                ty_id = useridList.get(random.nextInt(useridList.size()));
            } else {
                ty_cpsId = useridList.get(random.nextInt(useridList.size()));
            }
        }
        if (useridList.size() < 1000) {
            useridList.add(userId);
        }
        return
        new UserInfo(
                userId,
                "01",
                lastName[random.nextInt(lastName.length)] + firstName[random.nextInt(firstName.length)] + "",
                TimeUtil.getTime12(),
                phones[0],
                ty_id, // TODO
                ty_cpsId, // TODO
                SecurityUtil.hashWithBase64Encoded("md5", "123".getBytes("utf-8")),
                phones[1],
                statuss[random.nextInt(statuss.length)]
        );
    }

    public UserInfo(String u_i_id, String u_i_type, String real_name, String create_date_time, String phone_v, String ty_id,
                    String ty_cpsid, String pass_word, String phone, String status) {
        this.u_i_id = u_i_id;
        this.u_i_type = u_i_type;
        this.real_name = real_name;
        this.create_date_time = create_date_time;
        this.phone_v = phone_v;
        this.ty_id = ty_id;
        this.ty_cpsid = ty_cpsid;
        this.pass_word = pass_word;
        this.phone = phone;
        this.status = status;
    }

    public String getU_i_id() {
        return u_i_id;
    }

    public void setU_i_id(String u_i_id) {
        this.u_i_id = u_i_id;
    }

    public String getU_i_type() {
        return u_i_type;
    }

    public void setU_i_type(String u_i_type) {
        this.u_i_type = u_i_type;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getCreate_date_time() {
        return create_date_time;
    }

    public void setCreate_date_time(String create_date_time) {
        this.create_date_time = create_date_time;
    }

    public String getPhone_v() {
        return phone_v;
    }

    public void setPhone_v(String phone_v) {
        this.phone_v = phone_v;
    }

    public String getTy_id() {
        return ty_id;
    }

    public void setTy_id(String ty_id) {
        this.ty_id = ty_id;
    }

    public String getTy_cpsid() {
        return ty_cpsid;
    }

    public void setTy_cpsid(String ty_cpsid) {
        this.ty_cpsid = ty_cpsid;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // String u_i_id, String u_i_type, String real_name, String create_date_time, String phone_v, String ty_id,
    // String ty_cpsid, String pass_word, String phone, String status
    @Override
    public String toString() {
        return new StringBuffer("UserInfo : [ ")
                .append(u_i_id).append(" , ")
                .append(u_i_type).append(" , ")
                .append(real_name).append(" , ")
                .append(create_date_time).append(" , ")
                .append(phone_v).append(" , ")
                .append(ty_id).append(" , ")
                .append(ty_cpsid).append(" , ")
                .append(pass_word).append(" , ")
                .append(phone)
                .append(" ]").toString();
    }
}

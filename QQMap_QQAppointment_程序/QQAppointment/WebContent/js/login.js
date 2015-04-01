/**
 * @charset "utf-8"
 * @author Daniel Zhang
 */
function checkLogin(){
    if (v("username") == "") {
        e("loginMsg").innerHTML = "用户名不能为空!";
        e("username").focus();
        return false;
    }
    else 
        if (v("password") == "") {
            e("loginMsg").innerHTML = "密码不能为空!";
            e("password").focus();
            return false;
        }
        else return true;
}
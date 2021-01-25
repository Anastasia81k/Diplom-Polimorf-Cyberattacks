package sample;

public class Result extends Attack{
    private double threat;

    public Result(double duration_1, double src_bytes_2, double dst_bytes_3, double land_4, double wrong_fragment_5, double urgent_6, double hot_7, double num_failed_logins_8, double logged_in_9, double num_compromised_10, double root_shell_11, double su_attempted_12, double num_root_13, double num_file_creations_14, double num_shells_15, double num_access_files_16, double num_outbound_cmds_17, double is_host_login_18, double is_guest_login_19, double count_20, double srv_count_21, double serror_rate_22, double srv_serror_rate_23, double rerror_rate_24, double srv_rerror_rate_25, double same_srv_rate_26, double diff_srv_rate_27, double srv_diff_host_rate_28, double dst_host_count_29, double dst_host_srv_count_30, double dst_host_same_srv_rate_31, double dst_host_diff_srv_rate_32, double dst_host_same_src_port_rate_33, double dst_host_srv_diff_host_rate_34, double dst_host_serror_rate_35, double dst_host_srv_serror_rate_36, double dst_host_rerror_rate_37, double dst_host_srv_rerror_rate_38, double threat) {
        super(duration_1, src_bytes_2, dst_bytes_3, land_4, wrong_fragment_5, urgent_6, hot_7, num_failed_logins_8, logged_in_9, num_compromised_10, root_shell_11, su_attempted_12, num_root_13, num_file_creations_14, num_shells_15, num_access_files_16, num_outbound_cmds_17, is_host_login_18, is_guest_login_19, count_20, srv_count_21, serror_rate_22, srv_serror_rate_23, rerror_rate_24, srv_rerror_rate_25, same_srv_rate_26, diff_srv_rate_27, srv_diff_host_rate_28, dst_host_count_29, dst_host_srv_count_30, dst_host_same_srv_rate_31, dst_host_diff_srv_rate_32, dst_host_same_src_port_rate_33, dst_host_srv_diff_host_rate_34, dst_host_serror_rate_35, dst_host_srv_serror_rate_36, dst_host_rerror_rate_37, dst_host_srv_rerror_rate_38);
        this.threat = threat;
    }

    public double getThreat() {
        return threat;
    }

    public void setThreat(double threat) {
        this.threat = threat;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Attack{" +
                "duration_1=" + getDuration_1() +
                ", src_bytes_2=" + getSrc_bytes_2() +
                ", dst_bytes_3=" + getDst_bytes_3() +
                ", land_4=" + getLand_4() +
                ", wrong_fragment_5=" + getWrong_fragment_5() +
                ", urgent_6=" + getUrgent_6() +
                ", hot_7=" + getHot_7() +
                ", num_failed_logins_8=" + getNum_failed_logins_8() +
                ", logged_in_9=" + getLogged_in_9() +
                ", num_compromised_10=" + getNum_compromised_10() +
                "threat=" + threat +
                '}';
    }




}

package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashAttack {
    //List<Attack> attackList;

    //public static void registerMonitoringAttack(Map<String, Object> conf, Attack attack ){
    public static Map<String, Double> createMap(Attack attack) {
        Map<String, Double> map = new HashMap<>();
        map.put("duration_1", attack.getDuration_1());
        map.put("src_bytes_2", attack.getSrc_bytes_2());
        map.put("dst_bytes_3", attack.getDst_bytes_3());
        map.put("land_4", attack.getLand_4());
        map.put("wrong_fragment_5", attack.getWrong_fragment_5());
        map.put("urgent_6", attack.getUrgent_6());
        map.put("hot_7", attack.getHot_7());
        map.put("num_failed_logins_8", attack.getNum_failed_logins_8());
        map.put("logged_in_9", attack.getLogged_in_9());
        map.put("num_compromised_10", attack.getNum_compromised_10());
        map.put("root_shell_11", attack.getRoot_shell_11());
        map.put("su_attempted_12", attack.getSu_attempted_12());
        map.put("num_root_13", attack.getNum_root_13());
        map.put("num_file_creations_14", attack.getNum_file_creations_14());
        map.put("num_shells_15", attack.getNum_shells_15());
        map.put("num_access_files_16", attack.getNum_access_files_16());
        map.put("num_outbound_cmds_17", attack.getNum_outbound_cmds_17());
        map.put("is_host_login_18", attack.getIs_host_login_18());
        map.put("is_guest_login_19", attack.getIs_guest_login_19());
        map.put("count_20", attack.getCount_20());
        map.put("srv_count_21", attack.getSrv_count_21());
        map.put("serror_rate_22", attack.getSerror_rate_22());
        map.put("srv_serror_rate_23", attack.getSrv_serror_rate_23());
        map.put("rerror_rate_24", attack.getRerror_rate_24());
        map.put("srv_rerror_rate_25", attack.getSrv_rerror_rate_25());
        map.put("same_srv_rate_26", attack.getSame_srv_rate_26());
        map.put("diff_srv_rate_27", attack.getDiff_srv_rate_27());
        map.put("srv_diff_host_rate_28", attack.getSrv_diff_host_rate_28());
        map.put("dst_host_count_29", attack.getDst_host_count_29());
        map.put("dst_host_srv_count_30", attack.getDst_host_srv_count_30());
        map.put("dst_host_same_srv_rate_31", attack.getDst_host_same_srv_rate_31());
        map.put("dst_host_diff_srv_rate_32", attack.getDst_host_diff_srv_rate_32());
        map.put("dst_host_same_src_port_rate_33", attack.getDst_host_same_src_port_rate_33());
        map.put("dst_host_srv_diff_host_rate_34", attack.getDst_host_srv_diff_host_rate_34());
        map.put("dst_host_serror_rate_35", attack.getDst_host_serror_rate_35());
        map.put("dst_host_srv_serror_rate_36", attack.getDst_host_srv_serror_rate_36());
        map.put("dst_host_rerror_rate_37", attack.getDst_host_rerror_rate_37());
        map.put("dst_host_srv_rerror_rate_38", attack.getDst_host_srv_rerror_rate_38());
/*
       map = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));


*/
       // System.out.println(map);
        double defaultValue = -10.0;
        map = replaceNullValues(map, defaultValue);
        System.out.println("Map with null value replaced: "
                + map);



        return map;

    }

    public static <T, K> Map<K, T>
    replaceNullValues(Map<K, T> map, T defaultValue)
    {

        // Replace the null value
        map = map.entrySet()
                .stream()
                .map(entry -> {
                    if (entry.getValue() == null)
                        entry.setValue(defaultValue);
                    return entry;
                })
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));

        return map;
    }
}

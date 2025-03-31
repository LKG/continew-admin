package top.continew.admin.controller.monitor;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author gg
 * 缓存信息
 */
@Data
public class CacheListInfoVo {
    private Properties info;

    private Long dbSize;

    private List<Map<String, String>> commandStats;

}

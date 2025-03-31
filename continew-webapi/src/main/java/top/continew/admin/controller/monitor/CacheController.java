package top.continew.admin.controller.monitor;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.auth.model.resp.OnlineUserResp;
import top.continew.starter.extension.crud.model.resp.PageResp;

import java.util.*;

@Tag(name = "缓存管理 API")
@RestController
@RequestMapping("/monitor/cache")
@RequiredArgsConstructor
public class CacheController {
    private final RedissonConnectionFactory connectionFactory;
    @GetMapping()
    @Operation(summary = "分页查询列表", description = "分页查询列表")
    @SaCheckPermission("monitor:cache:list")
    public PageResp<OnlineUserResp> getInfo(){
        RedisConnection connection = connectionFactory.getConnection();
        Properties commandStats = connection.commands().info("commandstats");
        List<Map<String, String>> pieList = new ArrayList<>();
        if (commandStats != null) {
            commandStats.stringPropertyNames().forEach(key -> {
                Map<String, String> data = new HashMap<>(2);
                String property = commandStats.getProperty(key);
                data.put("name", StringUtils.removeStart(key, "cmdstat_"));
                data.put("value", StringUtils.substringBetween(property, "calls=", ",usec"));
                pieList.add(data);
            });
        }
        CacheListInfoVo infoVo = new CacheListInfoVo();
        infoVo.setInfo(connection.commands().info());
        infoVo.setDbSize(connection.commands().dbSize());
        infoVo.setCommandStats(pieList);
        return null;
    }

    @SaCheckPermission("monitor:cache:list")
    @GetMapping("/getNames")
    public void cache() {

    }

    @SaCheckPermission("monitor:cache:list")
    @GetMapping("/getKeys/{cacheName}")
    public void getCacheKeys(@PathVariable String cacheName) {

    }

    @SaCheckPermission("monitor:cache:list")
    @GetMapping("/getValue/{cacheName}/{cacheKey}")
    public void getCacheValue(@PathVariable String cacheName, @PathVariable String cacheKey) {

    }
    @SaCheckPermission("monitor:cache:clear")
    @DeleteMapping("/clearCacheName/{cacheName}")
    public void clearCacheName(@PathVariable String cacheName){

    }

    @SaCheckPermission("monitor:cache:clear")
    @DeleteMapping("/clearCacheKey/{cacheKey}")
    public void clearCacheKey(@PathVariable String cacheKey) {

    }

    @SaCheckPermission("monitor:cache:clear")
    @DeleteMapping("/clearCacheAll")
    public void clearCacheAll() {

    }
}

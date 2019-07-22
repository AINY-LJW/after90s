///**============================================================
// * 版权： 
// * 包： com.after90s.frame.config
// * 修改记录：
// * 日期                作者           内容
// * =============================================================
// * 2019年7月20日       LJW        
// * ============================================================*/
//
//package com.after90s.frame.config;
//
//import org.springframework.boot.autoconfigure.cache.CacheProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Configuration;
//import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.concurrent.TimeUnit;
///**
// * <p>TODO 在类里通过@Bean注解生成RedisCacheManager和EhCacheCacheManage
// * 实现两种方法缓存
// * </p>
// *
// * @author LJW
// * @version 2019年7月20日
// */
////@Configuration
////@EnableCaching
////@EnableConfigurationProperties(CacheProperties.class)
//public class CacheManagerConfig {
//	 private final CacheProperties cacheProperties;
//
//	    CacheManagerConfig(CacheProperties cacheProperties) {
//	        this.cacheProperties = cacheProperties;
//	    }
//
//	    /**
//	     * cacheManager名字
//	     */
//	    public interface CacheManagerNames {
//	        /**
//	         * redis
//	         */
//	        String REDIS_CACHE_MANAGER = "redisCacheManager";
//
//	        /**
//	         * ehCache
//	         */
//	        String EHCACHE_CACHE_MAANGER = "ehCacheCacheManager";
//	    }
//
//	    /**
//	     * 缓存名，名称暗示了缓存时长 注意： 如果添加了新的缓存名，需要同时在下面的RedisCacheCustomizer#RedisCacheCustomizer里配置名称对应的缓存时长
//	     * ，时长为0代表永不过期；缓存名最好公司内部唯一，因为可能多个项目共用一个redis。
//	     *
//	     * @see RedisCacheCustomizer#customize(RedisCacheManager)
//	     */
//	    public interface CacheNames {
//	        /** 15分钟缓存组 */
//	        String CACHE_15MINS = "cp_salary:cache:15m";
//	        /** 30分钟缓存组 */
//	        String CACHE_30MINS = "cp_salary:cache:30m";
//	        /** 60分钟缓存组 */
//	        String CACHE_60MINS = "cp_salary:cache:60m";
//	        /** 180分钟缓存组 */
//	        String CACHE_180MINS = "cp_salary:cache:180m";
//	    }
//
//	    /**
//	     * ehcache缓存名
//	     */
//	    public interface EhCacheNames {
//	        String CACHE_10MINS = "cp_salary:cache:10m";
//
//	        String CACHE_20MINS = "cp_salary:cache:20m";
//
//	        String CACHE_30MINS = "cp_salary:cache:30m";
//	    }
//
//	    @Bean
//	    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//	        RedisTemplate redisTemplate = new RedisTemplate();
//	        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//	        redisTemplate.setKeySerializer(new StringRedisSerializer());
//	        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
//	        redisTemplate.afterPropertiesSet();
//	        return redisTemplate;
//	    }
//
//	    /**
//	     * @TODO    修改
//	     * 默认的redisCacheManager
//	     * @param redisTemplate 通过参数注入，这里没有手动给它做配置。在引入了redis的jar包，并且往
//	     * application.yml里添加了spring.redis的配置项，springboot的autoconfig会自动生成一个
//	     * redisTemplate的bean
//	     * @return
//	     */
//	    @Bean
//	    public RedisCacheManager redisCacheManager(RedisTemplate<Object, Object> redisTemplate) {
////	        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
////	        cacheManager.setUsePrefix(true);
////	        this.redisCacheManagerCustomizer().customize(cacheManager);
////	        return cacheManager;
//	    	return null;
//	    }
//
//	    /** cache的一些自定义配置 */
//	    @Bean
//	    public RedisCacheCustomizer redisCacheManagerCustomizer() {
//	        return new RedisCacheCustomizer();
//	    }
//
//	    private static class RedisCacheCustomizer
//	            implements CacheManagerCustomizer<RedisCacheManager> {
//	        /** CacheManager缓存自定义初始化比较早，尽量不要@autowired 其他spring 组件 */
//	        @Override
//	        public void customize(RedisCacheManager cacheManager) {
//	            // 自定义缓存名对应的过期时间
////	            Map<String, Long> expires = ImmutableMap.<String, Long>builder()
//	        	Map<String, Long> expires = new TreeMap<String, Long>();
//	        			expires .put(CacheNames.CACHE_15MINS, TimeUnit.MINUTES.toSeconds(15));
//	        			expires  .put(CacheNames.CACHE_30MINS, TimeUnit.MINUTES.toSeconds(30));
//	        			expires.put(CacheNames.CACHE_60MINS, TimeUnit.MINUTES.toSeconds(60));
//	        			expires .put(CacheNames.CACHE_180MINS, TimeUnit.MINUTES.toSeconds(180));
//	            // spring cache是根据cache name查找缓存过期时长的，如果找不到，则使用默认值
//	                    /**
//	                     * TODO
//	                     */
////	            cacheManager.setDefaultExpiration(TimeUnit.MINUTES.toSeconds(30));
////	            cacheManager.setExpires(expires);
//	        }
//	    }
//
//		/**
//		* 创建ehCacheCacheManager
//		*/
//	    @Bean
//	    public EhCacheCacheManager ehCacheCacheManager() {
//	        Resource location = this.cacheProperties
//	                .resolveConfigLocation(this.cacheProperties.getEhcache().getConfig());
//	        return new EhCacheCacheManager(EhCacheManagerUtils.buildCacheManager(location));
//	    }
//}

/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.post.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.core.project.post.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.after90s.core.project.post.domin.PostEntity;
import com.after90s.core.project.post.service.IPostService;
import com.after90s.frame.web.controller.BaseController;
import com.after90s.frame.web.domin.MessageEntity;
import com.after90s.frame.web.page.domin.TableDataInfoEntity;

/**
 * <p>TODO 岗位Controller</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */
@Controller
@RequestMapping("/system/post")
public class PostController extends BaseController{

    private String prefix = "system/post";

    @Autowired
    private IPostService postService;

    @RequiresPermissions("system:post:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/post";
    }

    @RequiresPermissions("system:post:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfoEntity list(PostEntity post)
    {
        startPage();
        List<PostEntity> list = postService.selectPostList(post);
        return getDataTable(list);
    }

    /**
     * 删除
     */
//    @Log(title = "系统管理", action = "岗位管理-删除岗位")
    @RequiresPermissions("system:post:remove")
    @RequestMapping("/remove/{postId}")
    @ResponseBody
    public MessageEntity remove(@PathVariable("postId") Long postId)
    {
        PostEntity post = postService.selectPostById(postId);
        if (post == null)
        {
            return MessageEntity.error("岗位不存在");
        }
        if (postService.selectCountPostById(postId) > 0)
        {
            return MessageEntity.error("岗位已分配,不能删除");
        }
        if (postService.deletePostById(postId) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    @RequiresPermissions("system:post:batchRemove")
//    @Log(title = "系统管理", action = "岗位管理-批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    public MessageEntity batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = postService.batchDeletePost(ids);
        if (rows > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    /**
     * 新增岗位
     */
//    @Log(title = "系统管理", action = "岗位管理-新增岗位")
    @RequiresPermissions("system:post:add")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 修改岗位
     */
//    @Log(title = "系统管理", action = "岗位管理-修改岗位")
    @RequiresPermissions("system:post:edit")
    @GetMapping("/edit/{postId}")
    public String edit(@PathVariable("postId") Long postId, Model model)
    {
        PostEntity post = postService.selectPostById(postId);
        model.addAttribute("post", post);
        return prefix + "/edit";
    }

    /**
     * 保存岗位
     */
//    @Log(title = "系统管理", action = "岗位管理-保存岗位")
    @RequiresPermissions("system:post:save")
    @PostMapping("/save")
    @ResponseBody
    public MessageEntity save(PostEntity post)
    {
        if (postService.savePost(post) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }


}

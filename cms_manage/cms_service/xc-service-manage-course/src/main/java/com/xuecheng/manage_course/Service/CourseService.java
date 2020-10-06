package com.xuecheng.manage_course.Service;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.*;
import com.xuecheng.manage_course.dao.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    TeachplanMapper teachplanMapper;
    @Autowired
    TeachplanRepository teachplanRepository;
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    // 查询课程计划
    public TeachplanNode findTeachplanList(String courseId) {
        return teachplanMapper.selectTeachplanList(courseId);
    }

    // 添加课程计划
    @Transactional // MySQL增删改操作要添加事务
    public ResponseResult addTeachplan(Teachplan teachplan) {
        if (teachplan != null ||
                StringUtils.isNotEmpty(teachplan.getCourseid()) ||
                StringUtils.isNotEmpty(teachplan.getPname())) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        // 课程id
        String courseid = teachplan.getCourseid();
        Optional<CourseBase> courseBaseOptional = courseBaseRepository.findById(courseid);// 获取课程信息
        CourseBase courseBase = null;
        if (!courseBaseOptional.isPresent()) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }else{
            courseBase = courseBaseOptional.get();
        }

        // 要处理parentId,如果用户没有输入,那就从当前课程的plan获取,如果当前课程没有plan就新建一个plan,将parentid设置为0
        String parentid = teachplan.getParentid();
        if (StringUtils.isEmpty(parentid)) {
            // 如果上级id(根节点)为空, 表示在页面中没有填写, 说明要添加的课程计划是当前课程的直接子节点,则存入课程的根节点(parentid=0)作为parentId
            List<Teachplan> teachplans = teachplanRepository.findByCourseidAndParentid(courseid, "0");
            if (teachplans == null || teachplans.size()<=0) {
                // 查询不到根节点,说明该课程还没有teachplan,需要添加一个teachplan作为根节点
                Teachplan teachplan1 = new Teachplan();
                teachplan1.setParentid("0");
                teachplan1.setGrade("1");
                teachplan1.setPname(courseBase.getName());
                teachplan1.setCourseid(courseid);
                teachplan1.setStatus("0");
                teachplanRepository.save(teachplan1);
                parentid = "0";
            }else{
                parentid = teachplans.get(0).getId();
            }
        }
        // 新节点, 课程id是在进入页面时已经固定好的, 其他信息是用户从页面输入的
        Teachplan teachplanNew = new Teachplan();
        // 工具类, 用于对象之间的copy
        BeanUtils.copyProperties(teachplan,teachplanNew);
        teachplanNew.setParentid(parentid);
        teachplanNew.setCourseid(courseid);
        String parentGrade = teachplanRepository.findById(parentid).get().getGrade();
        if ("1".equals(parentGrade)) {
            teachplanNew.setGrade("2");  //父节点的grade + 1 ,grade从1到3
        }else{
            teachplanNew.setGrade("3");  //父节点的grade + 1 ,grade从1到3
        }
        teachplanRepository.save(teachplanNew);
        return  new ResponseResult(CommonCode.SUCCESS);
    }

    public QueryResponseResult fingAllCourseWithPic(int page, int size, CourseListRequest courseListRequest) {
        List<CourseBase> courseBases = courseInfoMapper.findAllCourseInfo();
        QueryResult<CourseBase> courseBaseQueryResult = new QueryResult<>();
        courseBaseQueryResult.setList(courseBases);
        courseBaseQueryResult.setTotal(courseBases.size());
        return new QueryResponseResult(CommonCode.SUCCESS, courseBaseQueryResult);
    }

    public CourseBase findCourseBaseById(String courseId) {
        return courseMapper.findCourseBaseById(courseId);
    }

    // 修改课程信息
    public ResponseResult updateCourseBase (String courseId, CourseBase courseBase) {
        CourseBase courseBaseOriginal = courseMapper.findCourseBaseById(courseId);
        if (courseBaseOriginal == null) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        courseBase.setId(courseId);
        courseBaseRepository.saveAndFlush(courseBase);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    // 新增课程信息
    public AddCourseResult addCourseBase(CourseBase courseBase) {
        courseBase.setStatus("202001"); //默认课程未发布
        courseBaseRepository.save(courseBase);
        return new AddCourseResult(CommonCode.SUCCESS, courseBase.getId());
    }
}

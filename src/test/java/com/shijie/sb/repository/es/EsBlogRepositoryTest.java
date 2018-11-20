//package com.shijie.sb.repository.es;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import com.shijie.sb.domain.es.EsBlog;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
///**
// * Created by ShiJie on 2018-11-20 22:59
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EsBlogRepositoryTest {
//
//    @Autowired
//    private EsBlogRepository esBlogRepository;
//
//    @Before
//    public void initRepositoryData() {
//        // 清除所有数据
//        esBlogRepository.deleteAll();
//
//        esBlogRepository.save(new EsBlog("登鹳雀楼", "唐代：王之涣",
//                "白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
//        esBlogRepository.save(new EsBlog("相思", "唐代：王维",
//                "红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
//        esBlogRepository.save(new EsBlog("静夜思", "唐代：李白",
//                "床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
//    }
//
//    @Test
//    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
//        Pageable pageable = new PageRequest(0, 20);
//        String title = "思";
//        String summary = "相思";
//        String content = "相思";
//        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
//                title, summary, content, pageable);
//        assertThat(page.getTotalElements()).isEqualTo(2);
//
//        for (EsBlog esBlog: page.getContent()) {
//            System.out.println(esBlog.toString());
//        }
//    }
//
//}
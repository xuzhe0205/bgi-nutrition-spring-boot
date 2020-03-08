package com.health.nutrition;

import com.health.nutrition.entity.*;
import com.health.nutrition.repository.*;
import com.health.nutrition.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NutritionApplicationTests {

	@Autowired
	private TFoodRepository tFoodRepository;

	@Autowired
	private TFoodRniRepository tFoodRniRepository;

	@Autowired
	private TFoodNutrientRepository tFoodNutrientRepository;

	@Autowired
	private TFoodRniService tFoodRniService;

	@Autowired
	private TFoodNutrientINQService tFoodNutrientINQService;

	@Autowired
	private TFoodNutrientService tFoodNutrientService;

	@Autowired
	private TFoodGiGlRepository tFoodGiGlRepository;

	@Autowired
	private TFoodTagsService tFoodTagsService;


	@Test
	public void contextLoads() {
		TFoodEntity tFoodEntity=tFoodRepository.getTFoodEntityByCode("01-1-0-001");
		System.out.println(tFoodEntity.getAlias());
	}

	@Test
	public void testRni(){
		List<TFoodRniEntity> list = tFoodRniRepository.getRniByBodyHorizontal((byte)1);
		System.out.println(list.size());
	}

	@Test
	public void testRecommendedFoodINQ() throws Exception {


		List<TFoodNutrientInqEntity> tFoodNutrientInqEntityList = new ArrayList<>();



		System.out.println("check recommendedFoodINQ size: " + tFoodNutrientInqEntityList.size());

	}

	@Test
	public void testGiglSorting(){
		List<TFoodGiglEntity> tFoodGiglEntityList = tFoodGiGlRepository.findAllSorted();
		for (TFoodGiglEntity tFoodGiglEntity : tFoodGiglEntityList){
			System.out.println("Food Code: " + tFoodGiglEntity.getFoodCode() + ", GL: " + tFoodGiglEntity.getGl());
		}
	}

	@Test
	public void testTFoodNutrientCombined(){
		List<TFoodNutrientEntity> tFoodNutrientEntityList = tFoodNutrientRepository.findAllGIGLFoodCombined();

		int cnt = 0;
		for (TFoodNutrientEntity tFoodNutrientEntity : tFoodNutrientEntityList){
			System.out.println("counter: " + cnt);
			System.out.println("Food code: " + tFoodNutrientEntity.getFoodCode());
			cnt ++;
		}
	}

	@Test
	public void testTFoodNutrientOneToOne(){
		List<TFoodNutrientEntity> tFoodNutrientEntityList = tFoodNutrientRepository.findAllGIGLFoodCombined();
        System.out.println("size:   " + tFoodNutrientEntityList.size());
	}

	@Test
	public void testAddFoodTags() throws Exception {
		List<TFoodTagsEntity> tFoodTagsEntityList = tFoodTagsService.addFoodTags();
		System.out.println("size:	" + tFoodTagsEntityList.size());
	}

	@Test
	public void testInqResultJoin() throws Exception {
		List<Object[]> foodInqResultList = tFoodRepository.findFoodInqCombinedCategoryResult(Arrays.asList("01","02","03"));
		System.out.println("testtetsttest" + foodInqResultList.size());
	}

	@Test
	public void testCombinedFoodInqResult() throws Exception{
		List<TFoodNutrientInqEntity> tFoodNutrientInqEntityList = tFoodNutrientINQService.findFoodNutrientINQByPage(0,30,"畜禽肉", "");
		System.out.println("balalalalalla" + tFoodNutrientInqEntityList.size());
	}

	@Test
	public void testSearchFoodByKeyword() throws Exception{
		List<TFoodNutrientInqEntity> resultList = tFoodNutrientINQService.findFoodNutrientINQByPage(0,300,"", "米");
		System.out.println("????!!!!!"+resultList.size());
	}

}

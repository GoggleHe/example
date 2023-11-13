package org.example.leetcode.solutions;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//
// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// 你可以按 任意顺序 返回答案 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
//
// Related Topics 数组 双指针 排序
// 👍 1796 👎 0


import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i]
                            + (long) nums[j]
                            + (long) nums[k]
                            + (long) nums[l];

                    if (sum == target) {
                        List<Integer> res = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        );
                        boolean exist = false;
                        for (int m = 0; m < result.size(); m++) {
                            Object[] integers = result.get(m).toArray();
                            Object[] objects = res.toArray();
                            if (isSame(integers, objects)) {
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            result.add(res);
                        }
                    }
                    if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return result;
    }

    boolean isSame(Object[] nums1, Object[] nums2) {
        if (nums1.length != nums2.length) {
            return false;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            if (!Objects.equals(nums1[i], nums2[i])) {
                return false;
            }
        }
        return true;
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "{'nums':[1,0,-1,0,-2,2],'target':0,'expected':[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]}",
            "{'nums':[1000000000,1000000000,1000000000,1000000000],'target':-294967296,'expected':[]}",
            "{'nums':[2,2,2,2,2],'target':8,'expected':[[2,2,2,2]]}",
            "{'nums':[2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2],'target':8,'expected':[[2,2,2,2]]}",
            "{'nums':[1,3,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2],'target':8,'expected':[[2,2,2,2],[1, 2, 2, 3]]}",
            "{'nums':[-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492],'target':1682,'expected':[[306,414,470,492],[310,439,441,492],[314,435,441,492],[331,440,441,470],[333,387,470,492],[333,439,440,470],[334,421,435,492],[347,408,435,492],[356,421,435,470],[357,414,441,470],[361,408,421,492],[367,435,439,441],[387,414,440,441],[387,421,435,439],[408,414,421,439]]}",
    })
    void testFourSum(@ConvertWith(JsonToParamConverter.class) Param param, TestReporter reporter) {
        Map<String, String> map = new HashMap<>();
        int[] nums = param.getNums();
        map.put("nums", Arrays.toString(nums));
        int target = param.getTarget();
        map.put("target", target + "");
        List<List<Integer>> expected = param.getExpected();
        map.put("expected", expected.toString());


        List<List<Integer>> lists = fourSum(nums, target);
        map.put("actual", lists.toString());
        reporter.publishEntry(map);
        // assertNotNull(lists);
        // assertEquals(expected.size(), lists.size());

        assertTrue(CollectionUtils.isEqualCollection(lists, expected));


    }

    @Test
    void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }


    static class Param {
        private int[] nums;
        private int target;
        private List<List<Integer>> expected;

        public int[] getNums() {
            return nums;
        }

        public void setNums(int[] nums) {
            this.nums = nums;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public List<List<Integer>> getExpected() {
            return expected;
        }

        public void setExpected(List<List<Integer>> expected) {
            this.expected = expected;
        }
    }

    static class JsonToParamConverter extends SimpleArgumentConverter {

        @Override
        protected Param convert(Object o, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Param.class, targetType);
            return JSON.parseObject(String.valueOf(o), Param.class);
        }
    }

    static Stream<Arguments> parameter() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 1, -4}, 1, 2),
                Arguments.of(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2, -2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


package org.example.leetcode.solutions;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution18Test {

    private Solution18 solution = new Solution18();

    @ParameterizedTest
    @ValueSource(strings = {
            "{'nums':[1,0,-1,0,-2,2],'target':0,'expected':[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]}",
            "{'nums':[1000000000,1000000000,1000000000,1000000000],'target':-294967296,'expected':[]}",
            "{'nums':[2,2,2,2,2],'target':8,'expected':[[2,2,2,2]]}",
            "{'nums':[2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2],'target':8,'expected':[[2,2,2,2]]}",
            "{'nums':[1,3,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2],'target':8,'expected':[[2,2,2,2],[1, 2, 2, 3]]}",
            "{'nums':[-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492],'target':1682,'expected':[[306,414,470,492],[310,439,441,492],[314,435,441,492],[331,440,441,470],[333,387,470,492],[333,439,440,470],[334,421,435,492],[347,408,435,492],[356,421,435,470],[357,414,441,470],[361,408,421,492],[367,435,439,441],[387,414,440,441],[387,421,435,439],[408,414,421,439]]}",
    })
    void fourSum(@ConvertWith(JsonToParamConverter.class) Param param, TestReporter reporter) {
        Map<String, String> map = new HashMap<>();
        int[] nums = param.getNums();
        map.put("nums", Arrays.toString(nums));
        int target = param.getTarget();
        map.put("target", target + "");
        List<List<Integer>> expected = param.getExpected();
        map.put("expected", expected.toString());


        List<List<Integer>> lists = solution.fourSum(nums, target);
        map.put("actual", lists.toString());
        reporter.publishEntry(map);
        // assertNotNull(lists);
        // assertEquals(expected.size(), lists.size());

        assertTrue(CollectionUtils.isEqualCollection(lists, expected));


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
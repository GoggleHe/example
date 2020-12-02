package org.example.leetcode.solutions;
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 609 👎 0

import java.util.Arrays;

/**
 *
 **/
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int left = 0; left + k <= nums.length; left++) {
            int max = nums[left];
            for (int i = left; i - left < k; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            result[left] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] nums = {-1546, 6139, 6207, 553, 4894, 6567, 9205, -6548, 6519, 4287, -4555, -3050, 3183, -7068, 5321, 7823, 9713, 1337, 522, -1826, -2074, 2214, 9267, 3022, -6532, -9354, 1620, -7061, 1260, 3554, -8824, -6245, 7582, 8629, 6594, -5797, -2994, 6863, 2582, 2750, -9591, -9405, -1307, 5700, 8120, -1711, 1058, -5152, -1246, -6095, 1755, -8345, -4684, -4670, 8616, -1677, -5411, 1451, 6138, -5942, -2608, 8329, 3193, 8008, -2174, 8290, -6577, -4359, -7453, -2912, -2559, -764, 1279, -7842, -180, 3959, 1608, 7500, 1001, -4043, -8815, 31, -460, -6726, 4073, 7141, -1616, 3277, 4929, -8631, -4976, 2007, 7134, 2994, -1034, 9736, -5034, -7310, 5867, -5851, -6445, 8303, 9847, -1523, -8404, -589, -1051, 486, 5971, 7838, 7134, 9457, 6981, -7031, 6197, 977, 2145, 9160, -6513, 3391, -2617, -8433, 8007, -4262, 8574, 6752, 8501, -7519, 5680, -2771, 5361, -1262, -1511, 1516, 4047, -2661, -7339, -1487, -8986, 8821, 4287, 4563, 746, -608, -2154, -7476, -1947, 9084, 6172, 3849, -8152, -672, -1507, 3650, 2777, -6716, 6729, -2818, -235, -4670, 9346, -5671, 5801, -2977, 6199, -283, 2134, 9452, 8436, 2080, 9263, -69, -5729, -7896, -6897, 8732, 3656, -8445, 92, 7925, 3774, 3144, -9371, 1532, 6965, 957, -4429, -6731, -950, 3854, -4954, 9101, 3077, -9137, -1202, -4551, 5466, -7421, -595, -7324, -9670, 6188, 5026, -3428, -3331, -7228, -1831, -2835, 5154, 1094, 3522, -1174, -6509, -6535, -5683, 7408, 6162, -6884, 21, 4603, -2499, 3207, -2538, -7862, -5890, 269, -4117, 1602, -1064, -3599, -8440, 4339, -6461, -5672, 2299, -2067, -5681, 1684, 9107, -1348, 7299, -6626, -4773, -1402, -3775, -4766, -4776, -7813, 9379, 3150, -8086, 7864, -7605, -9812, 7696, 632, -4309, 5832, -2870, 7021, 7060, 5938, -4276, -186, 5368, -4975, -6111, 6404, 3389, 813, 9243, 3295, -1047, 3946, 1065, -6626, -1225, -8339, -2757, 729, 5200, -6324, 5177, 5949, -3324, -15, -8821, -7713, -9035, -6478, -9153, -4628, 8214, 7096, -8415, 6692, -8936, 6067, -5946, -7840, 1531, 1449, 2475, 371, -4788, 4555, 1995, -4853, -3065, 8106, 7729, -224, -1362, 200, 5648, -3207, -3863, -6421, -277, 9729, 4207, 6104, 3473, 8782, 5257, -930, 5509, 705, 7369, 8200, 581, -9362, -534, 7364, 8817, 9863, -7258, -3391, -2213, -9468, -1605, 4307, 1413, -1276, 2525, 9973, 4269, 8175, 3207, 6399, -5694, -891, -46, -519, 4421, -9190, -9241, -240, -1154, 5155, 8473, -1884, 7735, 2831, -4697, 9655, -4585, -5008, -8564, 1190, -5444, 4092, -1824, 6824, 3215, -1309, -3434, -3813, -5543, 3545, -5381, 3965, -9259, -3788, 5107, 4467, -6732, 8784, 687, 1632, 56, 6243, 8406, 6210, -7919, -8488, -5942, -9280, 9098, -4604, 2836, -6490, -5182, -2673, -6961, -3573, -3243, 4691, 7392, -4663, 6181, -9798, -7191, 6570, -9003, -4470, 6437, -3726, 5741, -7457, 1094, 4923, -1122, 4717, 4613, 9886, 2664, 4198, 6727, -2927, -3340, -2899, -9749, -2677, 9103, 8518, -9986, -9839, 1440, 5680, -6462, -6721, 6471, -1837, -4731, 4309, 5872, 499, -2977, -826, 1811, 7780, 4171, 3115, -3730, 6473, 8879, 1923, 4901, -5767, -800, 8762, -127, 4201, 5198, 6927, -6254, -1762, -3991, -4244, -7761, -2244, -3997, -3678, 6026, -6464, -6790, -4548, -7836, 9512, -5048, -7615, 6405, -8335, -7783, -1267, 6520, 5438, -4002, 6154, 935, -654, 9594, -961, 2653, 2093, -7720, -7618, -2495, 7828, -198, -3564, -9065, -3717, -7604, -398, -8508, 6287, -272, 8463, -1638, 201, -2667, -7171, -8218, 8605, 7835, -3956, 4714, -989, -6433, -2221, 1147, 9098, -7625, 805, -8517, 310, 8831, -3925, 1737, -7259, -6542, 8871, 2679, 8469, 833, 1990, -9438, 254, 9272, 6682, 5501, 6613, -6558, 4858, -9831, 8691, 4006, -8446, 1889, -7795, -2292, 4385, 1885, 1069, -1181, 4355, 152, 1749, -2147, -3146, -9638, 2754, 5206, 9065, 6644, 2170, 5065, 3866, -9165, -9745, -7419, 8260, -4026, -4203, 9560, 1729, 5899, 7368, -7135, 8436, 1382, -5293, -4338, 7048, 9982, -3773, -2317, 4639, 5101, -672, 7565, 7615, 9909, -6764, 535, 1141, -5330, -7544, -1383, 7741, -3140, 8939, -5892, 2890, 9941, -5409, -9801, -4647, 384, 8040, -4107, -6742, -7713, -2525, 5749, -139, 8646, 3235, -1120, -8961, 8103, 3086, -102, -8274, 3238, 4632, -1859, -9038, -5376, 1637, 3113, 9971, 8179, -8298, -9823, -9779, -9233, 6797, 5890, 5565, 9916, 7474, -6049, -3950, -5597, -34, 3050, 5777, -6351, 2461, -1082, -2018, -10000, 4032, -7600, -9061, 1428, -410, -9827, 3360, 316, -5572, -4683, -712, -7073, 8179, 1194, -9898, -5097, 183, 5971, -9863, 2028, 6815, 8369, -6555, -7614, 7805, -7242, 6824, 7603, -8336, 7520, -9953, 1383, 9417, -4577, -3494, 8456, -1836, 6672, -4471, -1584, 2529, 6966, 1007, -2601, -5025, 6218, 9918, 7801, -833, -701, -8757, -1114, 8634, -7314, -3338, 302, -7084, -3991, -3386, 5519, -4466, -9390, -2729, 8769, 7941, -2219, 6013, 5217, -1328, -3506, -3061, 6844, -7004, 3690, -9695, -5233, 9294, 9943, 5877, -4888, 7180, -8413, 1418, 2065, 6013, 5801, -8711, 9088, 5772, -6201, 1903, -1730, 2284, 9733, -4611, 187, -4828, 3166, -8816, 3915, 9650, 8451, 3153, 5982, 4193, 8280, 7776, -6981, -3162, 821, -8478, 4993, 6526, 9116, 54, -1348, -1483, 534, 2033, -8466, -9795, -3972, 8870, 4098, -8405, 8106, 7330, 3398, -5800, 8448, 9728, 6886, -71, 1033, -2383, -2460, -4358, 442, -5354, -3627, -5478, -217, -5471, -3017, -1748, 2526, -2775, 8172, 3404, 6119, -8292, 8514, 3940, -2735, -3862, -8506, -6939, -6594, 745, -7861, 5286, 9004, 8709, 859, -9095, 806, -2252, 6481, -5683, 9064, 2712, -5117, -5114, 5436, -9, 8362, -7098, -5725, 6758, 4461, 6073, -4148, -8156, -789, 2881, -3085, 9502, -2662, 6898, -1650, -5004, -7485, 7000, -4411, 8084, -2808, -4997, -4330, -6446, 5562, 4363, 2125, 6546, 421, -734, -9715, -1903, -5906, 8955, 8331, 4885, 6934, 7311, 6455, -7904, -6253, 3026, 9751, -2493, -9987, -7192, -3658, 6925, 4574, 4696, 3381, -3209, 8190, 8481, 789, 2300, -751, 2312, 8269, -6233, 997, -420, -9267, 2701, 894, -3596, -839, -3511, 2103, -6465, -6712, -7376, -4420, 3165, -8085, -766, 4842, 9777, -6948, -1399, 8522, 5970, -6417, 9626, -9636, 2920, 7056, 439, 9682, -6686, 4743, -6757, 8569, -3553, -6220, 3241, -992, 7838, -8023, -3683, -4885, 8960, -6207, 8724, 1845, -2194, 5945, 3478, 6059, -7943, -1265, 8767, -8057, -6696, 6285, 9885, 6458, 8311, -7190, -7756, -3085, 3913, -4845, -9997, -334, 3985, 2277, 6174, 4716, 3973, -8116, 4177, 4285, -4290, 676, 254, 1577, 9463, -1051, 5660, 5114, -1107, 5811, -8616, -7895, 6338, -9454, -347, 9885, -9526, 3228, 2742, -4769, 9388, 1600, -3531, 7274, -6149, -7553, -3086, -7216, -8110, -7076, 6369, -8732, 8504, 5758, -3019, -7167, 7538, -3382, -6474, 9850, 2809, -77, -211, -6766, -509, 4329, -4607, 9313, 7937, 6983, -8173, -6601, -2769, 805, 6103, 3238, -6010, 5514, -4914, 2529, -8616, 4293, -8482, 9567, -5455, 762, -3278, 4385, 7939, -7710, 9195, -9676, -7794, 9182, -1841, -8466, -1906, 9029, -3642, -7611, 7050, -7832, -5978, -417, 9636, 8505, -59, -7532, -549, 1880, -1775, -9646, 7090, 5608, -6454, 5043, 3770, -8154, -1123, 2774, -2006, -4250, 9480, -2514, 7391, 2680, -4132, -9489, -3948, 6096, -155, 8797, -6480, 4149, -2202, -8570, 1817, 4410, -4492, 4516, -9263, 507, 7856, -9875, -3203, -6789, 3040, -4696, 7114, -6312, -9462, -70, 2181, -4962, 8384, 3001, 5331, -3403, 6112, -8386, 7321, -4205, -6864, -7017, -5865, -134, -8718, -2445, 1360, 5908, -3968, -1934, 1893, 3440, 1209, 77, 6531, -3348, -2349, 8324, -1855, -4377, -1612, -7221, -6808, -7525, 1446, 5181, 4073, 8587, 8501, 2235, 1912, 9844, -5317, -4623, -1184, 6613, -8886, -6557, -480, -7432, -5441, 7690, -7617, -2983, -4951, -5352, 7182, 1787, 7521, -7031, 8419, 7597, 8196, 9057, 485, -7135, -9755, 3754, -9722, -2882, 1389, -9197, 970, 4329, 8501, 8097, 1380, -7929, -8075, -536, -5401, 7585, -4047, 8829, 4683, 8183, -4430, 2707, 6034, -8554, 4000, 8764, 7591, -7771, 5021, -7835, -3972, 7329, -3127, -5183, 5008, -8368, -1809, 3797, -4229, -8311, 2123, 2884, 4171, 1076, 5652, 512, 6382, 4343, -7198, 6144, -5973, -9463, -3685, -446, 5767, 5969, 3840, -8268, 7720, 6224, 4302, 3377, 4935, 9009, -4033, -5319, 612, 2570, -1239, 1577, 5371, 5426, 4317, -959, 7243, 3794, 4719, 1976, -2839, -5509, 7481, -4620, 1892, 1798, -4276, -7449, -3360, 369, -6665, 9034, 2847, 2707, 1255, 6552, -5489, 5557, -3923, 5125, 4226, 9251, 8527, -38, 6325, -8044, -5528, 1569, -7668, -9877, -7408, 5612, -5075, -3750, -2503, 4186, 1299, 7004, -7466, -4138, -6172, 7917, 7337, -3119, -8725, 7718, 3436, 1590, 6306, -9538, -4121, -6441, -6781, 2352, 1478, -6801, 4919, 9180, -2116, -1712, -8193, 196, 4913, -5322, 2533, -82, -2295, 4098, -3925, -8906, -6613, 6442, -9208, -1425, -2406, -3114, -9227, -9503, -6798, -3735, 3809, 3611, -5351, -9748, 8739, -8495, 6836, -6587, -7244, 9921, -8913, 675, 1528, -2312, 8216, 8989, 6695, 7162, 9382, 5736, -1096, -1484, 8441, -1150, 9518, 3379, 48, -751, 2670, 1284, -959, 8840, 6735, -6465, -3844, 9994, 2568, 1426, -9152, 7037, 8413, 6420, 7226, 5896, 3229, -6316, 4123, -644, -6393, 2819, 6314, 2254, -2691, -3628, -951, 3814, 6835, 1702, 5221, 2003, 9660, -5720, 303, -6010, -1124, 5404, 7491, 1020, -4159, 8476, -7533, 5402, -6286, -5966, 2298, 8005, -4441, 3958, 4332, 2831, 321, -3009, -8698, -342, 8982, 6589, -5373, 9358, 2687, -4417, -2315, 9762, 4267, -4199, -7795, -999, -1765, 3058, -1544, 625, 8664, 3603, 9343, -5413, -2132, -8399, -3223, -5718, -2214, 5931, 150, 5670, -7215, 9896, -2405, 9772, -5854, 3983, 5177, -8498, 9249, -5968, -9207, -7898, 7291, -3089, -8452, -9650, -75, 5957, -3136, -4144, -2331, 6139, -1532, -5479, 3739, -45, -7197, -5809, -4177, 2097, -1489, 2691, 3163, 7884, 6059, -2792, -6260, -3, -3210, 9952, -4763, -4332, 9947, 5668, -8741, -26, 4851, 1835, 744, -595, -284, -533, -9549, -2809, -7040, 8954, 1425, -8258, 6605, 7322, -1501, 6553, -7590, -8090, 8728, -8010, 641, -3587, 4281, -8902, -6234, 7051, -1771, 2758, -8387, 2938, 606, -6174, -1535, 4811, 1786, 6116, -8127, -7245, -7377, -6730, -9842, 7713, -2208, -4133, 5489, 7159, 7072, 9837, -4606, 7793, -2024, -2337, 2695, -6245, 7820, 1185, -6397, -7130, 3958, 5866, -4457, -8864, 9229, 7229, 3165, -4622, 9238, 9679, -8952, -5014, 4207, 7316, -6185, -6702, -2578, 604, -4205, 9399, 1424, 6798, -583, 5857, 7436, 2620, -888, 2573, 2458, -1857, -7905, -3107, -4163, -5835, 1339, 6429, 1533, -5470, -3568, 9241, 2373, 3291, 2809, -1941, -8853, 5531, 6760, -3417, 6193, 203, 9825, -577, -776, -8764, -791, 4336, -2826, -9511, 4440, 1896, 38, 8601, -3222, 5560, -1245, 6353, 4375, 1605, -3147, -6747, -4831, -6054, 653, -8134, 5440, 5157, -9825, 5723, 5844, 9278, -1572, -5247, 1805, -9440, -4981, -6313, 5175, -3746, 3251, 3594, -9893, 764, -8240, -3958, 239, 1216, -3806, 1627, -7044, 3766, -9895, 2186, -6934, -5056, 8567, -7152, 5836, 6818, 8463, 2164, -8446, 2, 4436, 7031, 9647, -3000, 4660, 1580, -849, 4605, -5515, -8202, -6411, 7314, 5651, 4840, 5782, 2958, 5306, 7420, -8766, -2649, 6479, 9662, 5037, -5582, 3217, 3822, 6895, -3431, -6886, -8218, 784, 5266, 3004, -1195, 9842, -8867, 9882, -5059, 5611, -4488, 2755, -6666, 1651, -8786, 6695, 9191, -6233, 2780, -1638, 6944, 1042, -8778, -6229, -7944, -5664, 5507, 198, 7665, -2256, -9121, 8913, -9604, 8261, -2944, 9110, 1981, 819, -67, 4860, -7436, 1280, -220, -7506, 167, -1554, -6512, -333, 8193, 1952, -4756, 6884, 3333, -4952, -6985, 4458, 8618, -1793, 3230, -7068, 5499, 1155, -1832, -9977, -953, 1488, -292, 5755, -1336, -4235, 917, -9934, -5175, -262, -2521, -1592, 2919, -3920, -2319, -6943, 737, 8047, -9299, 540, 9724, -6750, -264, -8921, 5089, 586, 8346, -8300, 9543, -8239, -9278, -9938, -5451, -3791, 112, -2828, -4702, -7829, -7617, 4340, 8381, 3297, 1623, -4838, -6183, -4800, 2741, -7136, 6046, -8757, 5682, 9116, -7829, 691, 8909, -6964, 2651, 6847, 932, -8133, -90, -2026, 7773, 5106, 5629, 3447, -6950, 1842, 2510, 6259, 2632, -4155, 5113, 7009, -2273, 2746, 1219, -8664, 6392, -9082, 1662, 4715, 5387, 1467, 4271, -5093, 3189, 5673, -950, 882, -3711, -9802, 2604, -5204, -5888, -6258, -3018, 7701, 7927, 1389, -40, 8540, 4348, 3111, -9077, 6982, 9752, -9071, 3466, -4817, 5969, -55};
        int[] ints = solution239.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}

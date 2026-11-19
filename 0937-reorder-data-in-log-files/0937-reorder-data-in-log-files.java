class Solution {
        public String[] reorderLogFiles(String[] logs) {
                Arrays.sort(logs, (a, b) -> {
                            int idxA = a.indexOf(' ');
                                        int idxB = b.indexOf(' ');

                                                    boolean isDigitA = Character.isDigit(a.charAt(idxA + 1));
                                                                boolean isDigitB = Character.isDigit(b.charAt(idxB + 1));

                                                                            if (isDigitA && isDigitB) {
                                                                                            return 0; // Preserve relative order of digit-logs (TimSort is stable)
                                                                                                        }
                                                                                                                    if (isDigitA) {
                                                                                                                                    return 1; // Digit-log goes after letter-log
                                                                                                                                                }
                                                                                                                                                            if (isDigitB) {
                                                                                                                                                                            return -1; // Letter-log goes before digit-log
                                                                                                                                                                                        }

                                                                                                                                                                                                    String contentA = a.substring(idxA + 1);
                                                                                                                                                                                                                String contentB = b.substring(idxB + 1);
                                                                                                                                                                                                                            int cmp = contentA.compareTo(contentB);
                                                                                                                                                                                                                                        if (cmp != 0) {
                                                                                                                                                                                                                                                        return cmp;
                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                String idA = a.substring(0, idxA);
                                                                                                                                                                                                                                                                                            String idB = b.substring(0, idxB);
                                                                                                                                                                                                                                                                                                        return idA.compareTo(idB);
                                                                                                                                                                                                                                                                                                                });

                                                                                                                                                                                                                                                                                                                        return logs;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            }

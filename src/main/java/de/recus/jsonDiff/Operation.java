package de.recus.jsonDiff;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

enum Operation {
    ADD("add"),
    REMOVE("remove"),
    REPLACE("replace"),
    MOVE("move"),
    COPY("copy"),
    TEST("test");

    @SuppressWarnings("unchecked")
	private final static Map<String, Operation> OPS = new ImmutableMap.Builder()
            .put(ADD.rfcName, ADD)
            .put(REMOVE.rfcName, REMOVE)
            .put(REPLACE.rfcName, REPLACE)
            .put(MOVE.rfcName, MOVE)
            .put(COPY.rfcName, COPY)
            .put(TEST.rfcName, TEST)
            .build();


    private String rfcName;

    Operation(String rfcName) {
        this.rfcName = rfcName;
    }

    public static Operation fromRfcName(String rfcName) throws InvalidJsonDiffException {
        if (rfcName == null) throw new InvalidJsonDiffException("rfcName cannot be null");
        Operation op = OPS.get(rfcName.toLowerCase());
        if (op == null) throw new InvalidJsonDiffException("unknown / unsupported operation " + rfcName);
        return op;
    }

    public String rfcName() {
        return this.rfcName;
    }


}
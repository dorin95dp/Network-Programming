public interface YepProtocol {

    int VALID_MSG_LENGTH = 7;
    String processInput(String message);

    enum Vocabulary {

        MESSAGE("msg"), ACKNOWLEDGMENT("ack"), NEGATIVE("nak");
        private String tag;

        Vocabulary(String tag) { this.tag = tag; }
        public String getTag() { return tag; }
    }

}

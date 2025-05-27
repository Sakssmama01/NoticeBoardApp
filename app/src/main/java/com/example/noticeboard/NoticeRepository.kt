import com.example.noticeboard.Notice
import com.example.noticeboard.NoticeDao
import kotlinx.coroutines.flow.Flow

class NoticeRepository(private val noticeDao: NoticeDao) {

    val allNotices: Flow<List<Notice>> = noticeDao.getAllNotices()

    suspend fun insert(notice: Notice) {
        noticeDao.insert(notice)
    }

    suspend fun delete(notice: Notice) {
        noticeDao.delete(notice)
    }
}

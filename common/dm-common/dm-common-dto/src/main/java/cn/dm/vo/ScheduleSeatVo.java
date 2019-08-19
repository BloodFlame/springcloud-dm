package cn.dm.vo;

import java.io.Serializable;
import java.util.List;

/***
 * 排期座位VO
 */
public class ScheduleSeatVo implements Serializable{
    private Long scheduleId;
    private Long cinemaId;
    private List<SeatPriceVo> seatPriceList;
    private List<SeatInfoVo> seatInfoList;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public List<SeatPriceVo> getSeatPriceList() {
        return seatPriceList;
    }

    public void setSeatPriceList(List<SeatPriceVo> seatPriceList) {
        this.seatPriceList = seatPriceList;
    }

    public List<SeatInfoVo> getSeatInfoList() {
        return seatInfoList;
    }

    public void setSeatInfoList(List<SeatInfoVo> seatInfoList) {
        this.seatInfoList = seatInfoList;
    }
}
